package note.mqprocess.annotation;

import java.lang.annotation.*;

/**
 * 处理消息的方法
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DcMqProcessMethod {
    String value() default "";
}
