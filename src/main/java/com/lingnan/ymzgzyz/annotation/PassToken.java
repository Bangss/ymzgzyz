package com.lingnan.ymzgzyz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来跳过验证的
 * @author Bangss
 * @since 2020-5-15
 * RetentionPolicy.RUNTIME:这种类型的Annotations将被JVM保留,
 * 所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用。
 */
@Target({ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
