package com.example.controller.userdemo;

import com.example.pojo.UserDemo;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naruto on 2017/5/23.
 */
@Controller
@RequestMapping("/userDemo")
public class UserDemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public String getAllUser(Integer pageNum, Integer pageSize, Model model){
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<UserDemo> list = new ArrayList<>();
        list = userService.getAll();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo", pageInfo);
        return "userdemo/userlist";
    }
}
