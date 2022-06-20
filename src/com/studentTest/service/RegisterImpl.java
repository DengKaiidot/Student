package com.studentTest.service;


import com.studentTest.bean.User;
import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

public class RegisterImpl implements Register {

    @Override
    public void register(User u) {
        FileDao fd = new FileDaoImpl();
        fd.register(u);
    }
}
