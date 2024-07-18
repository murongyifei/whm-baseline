package space.whm.demo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeCount {
    /**
     * (单位毫秒)默认耗时 >1 毫秒打印日志.
     */
    long time() default 1;
}
