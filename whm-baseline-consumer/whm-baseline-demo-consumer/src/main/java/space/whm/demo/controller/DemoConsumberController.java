package space.whm.demo.controller;

//import org.apache.dubbo.config.annotation.DubboReference;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.whm.demo.aspect.TakeCount;
import space.whm.demo.service.DemoService;

@RestController
@RequestMapping("/baseline/demo/consumer")
public class DemoConsumberController {
    //@DubboReference
    @Resource
    private DemoService demoService;

    @TakeCount(time = 10)
    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String uid) {
        return demoService.sayHello(uid);
    }
}
