package space.whm.demo.aspect;

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

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
    public void doAfter(JoinPoint joinPoint,TakeCount takeCount){
        //记录结束时间,打印耗时日志
        long utime = System.currentTimeMillis() - startTime.get();
        if (utime > takeCount.time()) {
            log.info("{}.{} 耗时：{}ms",joinPoint.getSignature().getDeclaringType().getSimpleName(),joinPoint.getSignature().getName(),(utime));
        }
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            addLog(joinPoint,utime);
        } catch (Exception e){
            log.error("doAround日志记录异常，异常信息为:",e);
            throw e;
        }

    }

    /**
     *
     * @param joinPoint
     * @param utime
     */
    private void addLog(JoinPoint joinPoint,long utime){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        log.info("\n\r=======================================\n\r" +
                        "请求地址:{}\n\r"+
                        "请求方式:{}\n\r"+
                        "请求类方法:{}\n\r"+
                        "请求方法参数:{}\n\r"+
                        //"返回报文:{}\nr"+
                        "处理耗时:{} ms\n\r"+
                        "=====================================\r\n",
                request.getRequestURI(),
                request.getMethod(),
                joinPoint.getSignature(),
                JSONObject.toJSONString(joinPoint.getArgs()),
                //outParam
                utime
        );
    }
}
