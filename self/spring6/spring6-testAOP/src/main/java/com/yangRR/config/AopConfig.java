package com.yangRR.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.yangRR.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
}
