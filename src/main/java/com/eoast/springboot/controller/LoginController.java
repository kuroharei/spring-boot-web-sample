package com.eoast.springboot.controller;

import com.eoast.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(!userRepository.existsById(id)){
            map.put("idMsg","账号不存在");
            return "login";
        }else if(!userRepository.findById(id).get().getPassword().equals(password)){
            map.put("passwordMsg","密码错误");
            return "login";
        }else {
            session.setAttribute("loginUser",id);
            return "redirect:/main.html";
        }
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
