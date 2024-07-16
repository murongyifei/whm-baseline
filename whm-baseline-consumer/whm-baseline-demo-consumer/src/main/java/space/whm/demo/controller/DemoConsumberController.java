package space.whm.demo.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.whm.demo.service.DemoService;

@RestController
@RequestMapping("/baseline/demo/consumer")
public class DemoConsumberController {
    @DubboReference
    private DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String uid) {
        return demoService.sayHello(uid);
    }
}
