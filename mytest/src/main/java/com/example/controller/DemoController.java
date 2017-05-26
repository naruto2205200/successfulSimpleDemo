package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.UserDemo;
import com.example.service.UserService;
import com.example.util.DataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by naruto on 2017/5/18.
 */
@Controller
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getDemo")
    public String getDemo(Model model){
        model.addAttribute("name", "zhangsanlisi");
        return "/test/getDemo";
    }

    @RequestMapping("/userlist")
    public String getList(Model model){
        model.addAttribute("name", "zhangsanlisi");
        return "test/userlist";
    }

    @RequestMapping("/getListPage")
    @ResponseBody
    public String getListPage() {
        PageHelper.startPage(1, 10);
        List<UserDemo> list = userService.getAll();
        for (UserDemo user : list) {
            System.out.println(user.getUsername());
        }
        PageInfo<UserDemo> pageInfo = new PageInfo<UserDemo>(list);
        long total = pageInfo.getTotal();
        System.out.println("共有：" + total);
        JSONObject json = new JSONObject();
        json.put("list",list);
        return json.toString();
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public PageInfo selectList(Integer page,Integer rows,Model model){
        if (page == null) {
            page = 1;
        }
        if (rows == null) {
            rows =10;
        }
        PageHelper.startPage(page, rows);
        List<UserDemo> list = new ArrayList<>();
        list = userService.getAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
