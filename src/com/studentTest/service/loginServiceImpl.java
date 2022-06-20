package com.studentTest.service;

import com.studentTest.bean.User;
import com.studentTest.dao.LoginDao;
import com.studentTest.dao.LoginDaoImpl;

public class loginServiceImpl implements loginService{


    @Override
    public User loginService(User u) {
        LoginDao ld=new LoginDaoImpl();
        return ld.logindao(u);
    }
}
