package com.graduation.domain;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@PostMapping("test")
    @ResponseBody
    @CrossOrigin(allowCredentials = "true")
    public String tset1(HttpSession session, String username, String password) {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        return "OK";
    }

    @RequestMapping("test2")
    @ResponseBody
    @CrossOrigin(allowCredentials = "true")
    public String test2(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        System.out.println("session取出："+username+":"+password);
        return username+" : "+password;
    }
}
