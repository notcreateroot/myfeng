package com.zpark.springboot02configautoconfig;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02ConfigAutoconfigApplicationTests {


    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //日志的级别
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别，日志就只会在这个级别以以后的高级别生效
        logger.trace("跟踪轨迹trace!!!");
        logger.debug("调试debug!!!");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("自己定义的信息info!!!");
        logger.warn("警告warn！！！");
        logger.error("错误error!!!");
    }

}
