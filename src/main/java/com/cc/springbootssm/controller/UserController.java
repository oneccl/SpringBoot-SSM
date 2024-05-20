package com.cc.springbootssm.controller;

import com.cc.springbootssm.pojo.User;
import com.cc.springbootssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/11/29
 * Time: 17:34
 * Description:
 * **********************
 * Boot项目：主要用来管理框架
 * **********************
 */
// Spring Boot 框架
/*
 1、Spring Boot是整合Spring技术栈的一站式框架
 2、作用：提供了一系列项目对象模型(POM)来简化Maven配置
 3、特点：
   1）可以以jar包的形式独立运行，使用main方法启动内嵌的Tomcat服务器运行，不需要部署war包
   2）提供了约定的开箱即用的依赖模块(starter POM)来简化Maven配置
   3）自动化配置，根据Maven依赖模块，自动配置spring、springMVC等
   4）自带项目应用监控，提供程序的健康检查功能
   5）不需要xml文件配置，使用注解配置
 4、四大核心
   1）自动配置(Application主配置类中的@SpringBootApplication注解实现)
   2）起步依赖(pom.xml)
   3）Actuator
   4）命令行界面
 5、resource目录
   1）static: 存放静态资源，如html,css,js等；服务器可直接访问
   2）templates: 存放web页面的模板资源，服务器不能直接访问
   3）application.properties/application.yml: Spring boot的核心配置文件
 6、Application类(java包)：Spring boot程序启动的入口
 */

// Spring boot支持的模板引擎Thymeleaf(百里香叶)

// Spring boot不推荐使用(webapp下返回)jsp页面，推荐使用模板Thymeleaf(html页面)代替jsp
/*
1、jsp: 是官方标准的模板引擎，但存在很多缺点，逐渐被弃用
  1）后缀为.jsp，本质是将一个.html文件转化为.jsp(Servlet)，后台处理后最终返回
    一个html页面，浏览器无法直接识别.jsp文件，需要借助服务端才能访问
  2）动态页面每次修改打开都需要重新启动程序，输入链接，效率较低，且页面设计时间成本较高
2、Thymeleaf: 是适用于web和独立环境项目的现代服务器端Java模板引擎，选用html作为模板页
  1）动静分离：使用静态html页面，浏览器直接访问即可达到目标UI界面和应用，实现动静分离
    大大方便界面的修改和测试
  2）开箱即用：可以直接套用模板实现jstl、ognl等表达式效果
  3）多方言支持：可使用Spring标准方言或使用与SpringMVC完美集成的web可选模块(添加webapp
    模块，使用jsp，内置SpringMVC视图解析器),支持国际化
 */

// Spring boot使用SpringMVC和传统的jsp(步骤)
/*
1、创建项目时，不要勾选模板引擎Thymeleaf，添加webapp模块，在核心配置文件
  application.properties中配置SpringMVC的视图为.jsp：
   前缀：spring.mvc.view.prefix=/WEB-INF/pages/
   后缀：spring.mvc.view.suffix=.jsp
2、在pom.xml中添加Tomcat内编译jsp(Spring boot内嵌Tomcat不支持jsp)：jsp模板引擎依赖
   <dependency>
       <groupId>org.apache.tomcat.embed</groupId>
       <artifactId>tomcat-embed-jasper</artifactId>
   </dependency>
3、在controller层返回.jsp页面
 */

// @RestController：响应给前台Json格式的字符串
//@RestController
@Controller
public class UserController {

    @Resource
    private UserService userService;

    // 使用@RestController注解，响应给前台Json格式的字符串
    @GetMapping("/findUser")
    public Object findUser(){
        return userService.findById(22);
    }

    // Spring-Boot通过jsp页面响应前台数据
    @GetMapping("/userData")
    public String findUser(Model model){
        User user = userService.findById(22);
        model.addAttribute("findUser",user);
        return "userView";
    }

}
