package com.example.rstatistic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndex(Model model){
        return "index";
    }
    @GetMapping("/index")
    public String getHome(Model model){
        return  "index";
    }

}
