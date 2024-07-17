package space.whm.demo.service.impl;

//import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import space.whm.demo.service.DemoService;

//@DubboService
@Service
public class DemoServiceImpl implements DemoService {
	
	@Override
    public String sayHello(String name) {
        return "Hello: " + name;
    }

}