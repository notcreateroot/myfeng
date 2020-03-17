package com.zpark.springboot02configautoconfig.controller;


import com.zpark.springboot02configautoconfig.entity.Student;
import com.zpark.springboot02configautoconfig.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//        @RequestMapping({"/","/index"})
//        public String index(){
//            return "index";
//        }
        @RequestMapping("/success")
        public String success(Map<String,Object> map){
            map.put("hello","<h1>你好</h1>");
            map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
            Student student = new Student();
            student.setName("username");
            student.setAge(18);
            student.setSex("男");
            map.put("student",student);
            map.put("a1",0);
            map.put("a2",1);
            return "success";
        }

        @RequestMapping("yz")
        public String yz(Map<String,Object> map){
            Student student = new Student();
            student.setName("username");
            student.setAge(18);
            map.put("student",student);
            return "yz";
    }
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
            if (user.equals("aaa")){
                throw new UserNotExistException();
            }
            return "Hello Word";
    }

}
