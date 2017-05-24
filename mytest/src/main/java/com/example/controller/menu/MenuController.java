package com.example.controller.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by naruto on 2017/5/22.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping("/menuDemoFirst")
    public String getFirstMenu(){
        return "menu/menuDemoFirst";
    }
}
