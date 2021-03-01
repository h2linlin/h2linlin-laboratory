package note.mqprocess.annotation;

import java.lang.annotation.*;

/**
 * 包含有处理消息的方法的Controller
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DcMqProcessController {
//    @AliasFor(annotation = Component.class)
    String value() default "";
}
