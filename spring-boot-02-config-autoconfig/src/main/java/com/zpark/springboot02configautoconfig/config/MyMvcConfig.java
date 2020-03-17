package com.zpark.springboot02configautoconfig.config;

import com.zpark.springboot02configautoconfig.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/springboot02configautoconfig").setViewName("404");
    }

    //所有的webMvcConfigureAdapter组件都会i一起起作用
    @Bean//将组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            /**
             * 注册拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                         .excludePathPatterns("/","/login.html","/user/login");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }
        };
        return adapter;
    }
    //Ctrl+Alt+T，可以把代码包在一个块内，例如：try/catch
    //Ctrl+Alt+L，格式化代码
    //Alt+Shift+Up/Down，上/下移一行
    //Shift+F6，重构 – 重命名
    //Ctrl+X，删除行
    //Ctrl+D，复制行
    //Ctrl+Shift+Ctrl+C,复制文件名
    //Ctrl+Shift+C，复制文件完整路径
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
