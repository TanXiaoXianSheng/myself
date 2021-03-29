package cn.bcf.dubbo.demo01.consumer;

import cn.bcf.dubbo.demo01.rely.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        System.out.println(demoService.sayHello("hello hello"));
    }

}
