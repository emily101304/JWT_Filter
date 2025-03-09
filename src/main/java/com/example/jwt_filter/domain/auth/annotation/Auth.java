package com.example.jwt_filter.domain.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //ArgumentResolver의 파라미터에 사용하는 것!
@Retention(RetentionPolicy.RUNTIME)//Retention = '표지판', 이 주석이 Runtime에 살아 있어야 해서!
public @interface Auth {
}
