import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
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
