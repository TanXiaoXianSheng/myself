package cn.bcf.springbootdemo01.config;

import cn.bcf.springbootdemo01.third.RongLianService;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/14 11:17 上午
 */
@Component
public class FeignConfig {

    @Bean
    public RongLianService config() {
        RongLianService service = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(RongLianService.class, "https://8.140.169.0/");
        return service;
    }

    public static void main(String[] args) {
        RongLianService service = Feign.builder()
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(RongLianService.class, "https://8.140.169.0");

    }

}
