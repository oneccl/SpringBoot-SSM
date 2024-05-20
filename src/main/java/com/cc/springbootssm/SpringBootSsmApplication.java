package com.cc.springbootssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 映射文件对应的Dao接口：用于映射文件扫描
@MapperScan("com.cc.springbootssm.dao")
// Spring boot的核心注解，主要用于开启Spring自动配置
@SpringBootApplication
public class SpringBootSsmApplication {

    // main方法：boot项目启动的入口，内嵌Tomcat服务器
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSsmApplication.class, args);
    }

}
