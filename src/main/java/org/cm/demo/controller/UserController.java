package org.cm.demo.controller;

import org.cm.demo.entity.User;
import org.cm.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        List<User> users = userService.findAll();
        System.out.println(users);
        model.addAttribute("users", users);
        return "user/list";
    }
}
