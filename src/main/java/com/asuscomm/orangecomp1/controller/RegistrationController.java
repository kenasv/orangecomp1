package com.asuscomm.orangecomp1.controller;

import com.asuscomm.orangecomp1.allbd.Role;
import com.asuscomm.orangecomp1.allbd.User;
import com.asuscomm.orangecomp1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb= userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("messange", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);




        return "redirect:/login";
    }
}
