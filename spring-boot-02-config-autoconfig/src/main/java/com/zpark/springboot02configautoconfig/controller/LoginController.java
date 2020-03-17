package com.zpark.springboot02configautoconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session)
    {
        if (!StringUtils.isEmpty(username)) {
            if (!StringUtils.isEmpty(password)) {
                if (username.equals("admin") && password.equals("root")) {
                    map.put("msg", "登陆成功");
                    //登陆成功，防止表单重复提交，可以重定向到首页
                    session.setAttribute("LoginUser",username);
                    return "redirect:/main.html";
                } else {
                    map.put("msg3", "登陆失败，请从新输入！");
                    return "login";
                }
            }else {
               map.put("msg2", "密码不能为空！");
                return "login";
           }
        }else {
            map.put("msg1", "账号不能为空！");
            return "login";
        }
    }
}