package com.example.controller;

import com.example.service.RegisterValidateService;
import com.example.util.MobileResultUtils;
import com.example.util.SendMobileMsg;
import com.example.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

/**
 * Created by naruto on 2017/5/29.
 */
@Controller
public class ValidateController {
    @Autowired
    private RegisterValidateService service;

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "validate/registerEmailValidate";
    }

    /**
     * 发送邮件
     * @param request
     * @param response
     * @return
     * @throws ParseException
     */
    @RequestMapping(value="/user/register",method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView load(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String action = request.getParameter("action");
        System.out.println("-----r----"+action);
        ModelAndView mav=new ModelAndView();
        if("register".equals(action)) {
            //注册
            String email = request.getParameter("email");
            service.processregister(email);//发邮箱激活
            mav.addObject("text","注册成功");
            mav.setViewName("validate/register_success");
        }
        else if("activate".equals(action)) {
            //激活
            String email = request.getParameter("email");//获取email
            String validateCode = request.getParameter("validateCode");//激活码
            try {
                service.processActivate(email , validateCode);//调用激活方法
                mav.setViewName("validate/activate_success");
            } catch (ServiceException e) {
                request.setAttribute("message" , e.getMessage());
                mav.setViewName("validate/activate_failure");
            }
        }
        return mav;
    }

    /**
     * 发送短信
     * @return
     */
    @RequestMapping("/user/sendMobileMsg")
    public String sendMobileMsg(Model model){
        SendMobileMsg send = new SendMobileMsg();
        Map<String, String> map = null;
        String result ="";
        try {
                map = MobileResultUtils.getMobileResult(send.sendMobileMessage());
                int resutl = Integer.parseInt(map.get("code"));
                if(resutl>0){
                    result = "validate/mobileMsg_success";
                }else {
                    model.addAttribute("message", map.get("message"));
                    result = "validate/mobileMsg_failure";
                }
        } catch (IOException e) {
            //e.printStackTrace();
            map.put("message", "服务器繁忙！！");
            result = "error";
        }
        return result;
    }
}
