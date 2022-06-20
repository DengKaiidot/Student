package com.studentTest.service;

import com.studentTest.bean.Struct;
import com.studentTest.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface FileService {
    ArrayList<User> getAllStudent();

    User getFileByNameOrId(String v);

    User getAdmine(String id);

    ArrayList getPersonFile(String studentId);

    void del(String stu);

    void upScore(String stuId, String a, String b, String c, String d);

    void setDate(String name, String pwd, String phone, String a, String b, String c, String d);

    void uppwd(String id, String pwd);

    List<Struct> getPrecent();

    int getIdByNamePwd(String a, String c);
}
