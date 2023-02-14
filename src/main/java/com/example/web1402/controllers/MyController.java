package com.example.web1402.controllers;

import com.example.web1402.data.User;
import com.example.web1402.services.LoginService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;

@Controller
@AllArgsConstructor
public class MyController {

    LoginService loginService;

    @SneakyThrows
    @PostMapping("/login")
    public String doLogin(@RequestParam String login, @RequestParam String password, Model model) {
        User user = loginService.checkLogin(login, password);
        if (user!=null) {
            model.addAttribute("user", user);
            return "login";
        }
        else {
            model.addAttribute("failedlogin", login);
            return "fail";
        }
    }
}
