package space.whm.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * springboot 统计接口耗时
 * https://www.cnblogs.com/homle/p/18152874
 */
@Slf4j
@Aspect
@Component
public class TakeCountAspect {

    //用threadlocal记录当前线程的开始访问时间
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before("@annotation(takeCount)")
    public void doBefore(TakeCount takeCount){
        //记录开始时间
        startTime.set(System.currentTimeMillis());
    }

    @After("@annotation(takeCount)")
    public void doAfter(JoinPoint point,TakeCount takeCount){
        //记录结束时间,打印耗时日志
        long utime = System.currentTimeMillis() - startTime.get();
        if (utime > takeCount.time()) {
            log.info("{}.{} 耗时：{}ms",point.getSignature().getDeclaringType().getSimpleName(),point.getSignature().getName(),(utime));
        }
    }
}
