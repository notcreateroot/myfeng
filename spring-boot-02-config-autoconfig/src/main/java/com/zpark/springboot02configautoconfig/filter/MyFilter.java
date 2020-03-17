package com.zpark.springboot02configautoconfig.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    //过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process.....");
        filterChain.doFilter(servletRequest,servletResponse);
    }
    //销毁
    @Override
    public void destroy() {

    }
}
