package com.example.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by naruto on 2017/5/20.
 */
@Controller
public class indexController {
    /**
     * 设置默认首页失败，待定
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
