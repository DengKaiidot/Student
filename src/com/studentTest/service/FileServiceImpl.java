package com.studentTest.service;

import com.studentTest.bean.Struct;
import com.studentTest.bean.User;
import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService{
    FileDao fs = new FileDaoImpl();
    @Override
    public ArrayList<User> getAllStudent() {

        return fs.getAllStudent();
    }

    @Override
    public User getFileByNameOrId(String v) {
        return fs.getFileByNameOrId(v);
    }

    @Override
    public User getAdmine(String id) {
        return fs.getAdmine(id);
    }

    @Override
    public ArrayList getPersonFile(String studentId) {
        return fs.getPersonFile(studentId);
    }

    @Override
    public void del(String stu) {
        fs.del(stu);
    }

    @Override
    public void upScore(String stuId, String a, String b, String c, String d) {
        fs.upScore(stuId,a,b,c,d);
    }

    @Override
    public void setDate(String name, String pwd, String phone, String a, String b, String c, String d) {
        fs.setDate(name,pwd,phone,a,b,c,d);
    }

    @Override
    public void uppwd(String id, String pwd) {
        fs.uppwd(id,pwd);
    }

    @Override
    public List<Struct> getPrecent() {
        return fs.getPrecent();
    }

    @Override
    public int getIdByNamePwd(String a, String c) {
        return fs.getIdByNamePwd(a,c);
    }


}
