package com.icore.icoretest.controller;

import com.icore.icoretest.dao.IdentityCardDao;
import com.icore.icoretest.dao.UserDao;
import com.icore.icoretest.entity.IdentityCard;
import com.icore.icoretest.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import com.icore.icoretest.service.UserService;

import com.icore.icoretest.service.UserService;
@Controller
@RequestMapping("/identitycard")
public class IdentityCardController {

    private static final Logger logger = LoggerFactory.getLogger(IdentityCardController.class);


    @Autowired
    IdentityCardDao icardRepository;
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @Autowired
    public IdentityCardController(IdentityCardDao userRepository) {
        this.icardRepository = userRepository;
    }

    @GetMapping("/all")
    public String home(@Valid IdentityCard identityCard, BindingResult result, Model model)
    {
        model.addAttribute("icards",icardRepository.findAll());
        //model.addAttribute("user",new User());

        logger.info("Homer");
        return "identity_cards";
    }

    @GetMapping("/add")
    public String showSignUpForm(IdentityCard identityCard,Model model) {
        return "identity_add";
    }

    @PostMapping("/addicard")
    public String addUser(@Valid IdentityCard identityCard, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "identity_add";
        }

        icardRepository.save(identityCard);
        model.addAttribute("icards", icardRepository.findAll());
        return "identity_cards";
    }

    @ModelAttribute("userRoleOptions")
    public List<User> getUserRoleOptions()
    {
        return userService.getAllUsers();
        //return userDao.findAll();
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        IdentityCard icard = icardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("icard", icard);

        //logger.info("User:"+userDao.count());
        return "identity_update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid IdentityCard identityCard, BindingResult result, Model model) {
        if (result.hasErrors()) {
            identityCard.setId(id);
            return "identity_update";
        }

        icardRepository.save(identityCard);
        model.addAttribute("icards", icardRepository.findAll());
        return "identity_cards";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        IdentityCard icard = icardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        icardRepository.delete(icard);
        model.addAttribute("icards", icardRepository.findAll());
        return "identity_cards";
    }
}