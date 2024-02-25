package com.example.mywebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("home")
    public ModelAndView home(@RequestParam("name") String name, HttpSession session){

        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.setViewName("home");
        //System.out.println("hi");
        return mv;
    }
}
