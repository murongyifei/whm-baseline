package space.whm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.whm.demo.service.DemoService;


@RestController
@RequestMapping("/baseline/demo/provider")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String uid) {
        return demoService.sayHello(uid);
    }
}
