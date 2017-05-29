package com.example.service;

import com.example.util.ServiceException;

import java.text.ParseException;

/**
 * Created by naruto on 2017/5/29.
 */
public interface RegisterValidateService {
    public void processregister(String email);
    public void processActivate(String email , String validateCode)throws ServiceException, ParseException;
}
