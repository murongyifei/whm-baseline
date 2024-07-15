import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import space.whm.demo.service.DemoService;

@SpringBootTest(classes = TestService.class)
@ComponentScan(basePackages = "space.whm.demo")
public class TestService {

    @Autowired
    private DemoService demoService;

    @Test
    public void test() {
        System.out.println(demoService.sayHello("whm"));
    }
}
