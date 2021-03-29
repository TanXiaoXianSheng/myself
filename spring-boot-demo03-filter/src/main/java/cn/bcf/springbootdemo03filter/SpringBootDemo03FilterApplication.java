package cn.bcf.springbootdemo03filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo03FilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo03FilterApplication.class, args);
    }

}
