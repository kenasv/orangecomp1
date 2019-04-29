package com.asuscomm.orangecomp1;


import com.asuscomm.orangecomp1.allbd.Site;
import com.asuscomm.orangecomp1.repos.SiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private SiteRepo siteRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Site> sites = siteRepo.findAll();
        model.put("sites", sites);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String id, @RequestParam String adres, Map<String, Object> model){
       Site site = new Site(id, adres);

       siteRepo.save(site);

        Iterable<Site> sites = siteRepo.findAll();
        model.put("sites", sites);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Site> sites;
        if (filter != null && !filter.isEmpty()) {
            sites = siteRepo.findByAdresIs(filter);
        } else {
            sites = siteRepo.findAll();
        }
        model.put("sites", sites);
        return "main";
    }
}