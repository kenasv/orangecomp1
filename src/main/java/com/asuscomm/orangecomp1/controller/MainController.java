package com.asuscomm.orangecomp1.controller;


import com.asuscomm.orangecomp1.allbd.Site;
import com.asuscomm.orangecomp1.allbd.User;
import com.asuscomm.orangecomp1.repos.SiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private SiteRepo siteRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Site> sites = siteRepo.findAll();
        model.put("sites", sites);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String id,
            @RequestParam String adres,
            Map<String, Object> model
    ){
       Site site = new Site(id, adres, user);

       siteRepo.save(site);

        Iterable<Site> sites = siteRepo.findAll();
        model.put("sites", sites);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Site> sites;
        if (filter != null && !filter.isEmpty()) {
            sites = siteRepo.findByAdresContaining(filter);
        } else {
            sites = siteRepo.findAll();
        }
        model.put("sites", sites);
        return "main";
    }
}