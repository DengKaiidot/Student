package com.studentTest.selvlet;

import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        String phone=req.getParameter("phone");
        String a=req.getParameter("a");
        String b=req.getParameter("b");
        String c=req.getParameter("c");
        String d=req.getParameter("d");
        FileService f =new FileServiceImpl();
        f.setDate(name,pwd,phone,a,b,c,d);





    }
}
