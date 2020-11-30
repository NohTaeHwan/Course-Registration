package com.thnoh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home (Model model){

        return "index";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String testing (Model model){

        return "test";
    }


}
