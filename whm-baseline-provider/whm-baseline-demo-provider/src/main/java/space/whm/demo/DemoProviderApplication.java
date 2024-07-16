package space.whm.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"space.whm.demo.service.impl"})
public class DemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProviderApplication.class, args);
    }

}
