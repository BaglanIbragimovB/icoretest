package com.icore.icoretest.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icore.icoretest.entity.User;
import com.icore.icoretest.dao.UserDao;

@Controller
@RequestMapping("/citizen")
public class UserController {

    @Autowired
    UserDao userRepository;

    @Autowired
    public UserController(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public String home(@Valid User user, BindingResult result, Model model)
    {
        model.addAttribute("users",userRepository.findAll());
        return "citizens";
    }

    @GetMapping("/add")
    public String showSignUpForm(User user) {
        return "citizen_add";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "citizen_add";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "citizens";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "citizen_update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "citizen_update";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "citizens";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "citizens";
    }
}