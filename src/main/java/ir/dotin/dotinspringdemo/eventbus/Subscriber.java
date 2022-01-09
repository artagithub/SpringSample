package ir.dotin.dotinspringdemo.eventbus;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Subscriber {
    String value() default  GlobalEventBus.GLOBAL_EVENT_BUS_EXPRESSION;
}
