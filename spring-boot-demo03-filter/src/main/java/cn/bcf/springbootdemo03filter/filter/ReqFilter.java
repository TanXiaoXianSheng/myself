package cn.bcf.springbootdemo03filter.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.AbstractApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * https://mp.weixin.qq.com/s/f01KWO3d2zhoN0Qa9-Qb6w
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class ReqFilter implements Filter {

    public ReqFilter() {
        log.info("ReqFilter constructor......");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("ReqFilter init ......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("url={}, params={}", req.getRequestURI(), JSON.toJSONString(req.getParameterMap()));
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
        log.info("ReqFilter destroy ......");
    }
}
