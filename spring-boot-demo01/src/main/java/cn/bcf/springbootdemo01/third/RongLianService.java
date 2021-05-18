package cn.bcf.springbootdemo01.third;

import feign.HeaderMap;
import feign.Headers;
import feign.RequestLine;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/14 11:09 上午
 */
public interface RongLianService {

    /*@RequestLine("POST /third/productList")
    String productList(Page page);*/

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("POST /third/productList")
    String productList(Page page);

}
