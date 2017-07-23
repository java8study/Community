package kr.co.study.annotation;

import java.lang.annotation.*;

/**
 * Created by coupang on 2017. 5. 24..
 */
@Target(ElementType.TYPE) 
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mapper {
}
