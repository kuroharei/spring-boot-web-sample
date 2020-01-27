package com.eoast.springboot.controller;

import com.eoast.springboot.entities.User;
import com.eoast.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;


@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/register")
    public String insertUser(@RequestParam("id") String id,
                             @RequestParam("phoneNumbers") String phoneNumbers,
                             @RequestParam("password") String password,
                             @RequestParam("confirmPassword") String confirmPassword,
                             Map<String,Object> map){
        if(!id.matches("^[BHQ][0-9]{8}$")) {
            map.put("idMsg","学号格式错误");
            return "register";
        }else if(userRepository.existsById(id)){
            map.put("idMsg","账号已存在");
            return "register";
        }else if(!password.equals(confirmPassword)){
            map.put("passwordMsg","两次输入密码不一致");
            return "register";
        }else{
            User save = userRepository.save(new User(id,phoneNumbers,password));
            System.out.println(save);
            return "redirect:/";
        }
    }

}
