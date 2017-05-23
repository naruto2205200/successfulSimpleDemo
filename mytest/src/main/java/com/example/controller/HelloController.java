package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/5/19.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView md = new ModelAndView("/hello");
        Map<String, String> mp = new HashMap<>();
        mp.put("id", "1");
        mp.put("name", "zhangsan");
        mp.put("age", "19");
        md.addObject("map", mp);
        return md;
    }
}
