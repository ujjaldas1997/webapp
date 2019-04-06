package com.webapp.webapp.controllers;

import com.webapp.webapp.models.Users;
import com.webapp.webapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UsersRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserDashboard(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Users user = repository.findByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("modifyUser", user);
        return "index";
    }

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public String getAllUsers(Model model){
        List<Users> allUsers = repository.findAll();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
    public String deleteUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Users user = repository.findByUsername(username);
        repository.delete(user);
        SecurityContextHolder.getContext().setAuthentication(null);
        return "login";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String modifyUserData(@ModelAttribute Users modifyUser, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Users user = repository.findByUsername(username);
        modifyUser.setUsername(user.getUsername());
        modifyUser.setPassword(user.getPassword());
        repository.save(modifyUser);
        model.addAttribute("user", modifyUser);
        model.addAttribute("modifyUser", modifyUser);
        return "index";
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public String changePassword(@ModelAttribute Users changeUserPassword, Model model){
        model.addAttribute("changeUserPassword", new Users());
        return "change-password";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    public String updatePassword(@ModelAttribute Users changeUserPassword, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Users user = repository.findByUsername(username);
        user.setPassword(passwordEncoder.encode(changeUserPassword.getPassword()));
        repository.save(user);
        model.addAttribute("user", user);
        model.addAttribute("modifyUser", user);
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUp(Model model){
        model.addAttribute("addUser", new Users());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@ModelAttribute Users addUser){
        addUser.setPassword(passwordEncoder.encode(addUser.getPassword()));
        repository.save(addUser);
        return "login";
    }

    @RequestMapping(value = "/templates/login.html", method = RequestMethod.GET)
    public String userLogin(Model model){
        model.addAttribute("loginError", false);
        return "login";
    }

    @RequestMapping(value = "/templates/login-error.html", method = RequestMethod.GET)
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }
}
