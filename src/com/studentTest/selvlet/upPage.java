package com.studentTest.selvlet;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
* "upStu?admId=${admId}&stuId=${stuId}&a="+a+"&b="+b+"&c="+c+"&d="+d;
* */
@WebServlet("/upStu")
public class upPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        String stuId = req.getParameter("stuId");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String c = req.getParameter("c");
        String d = req.getParameter("d");
        System.out.println(admId+"  "+stuId+"  "+a+"  "+b+""+c+" "+d);
        FileService fs = new FileServiceImpl();
        fs.upScore(stuId,a,b,c,d);

        /*
        * 修改数据工作完毕
        * 在这里呢就是返回前端界面
        * */
        User user = fs.getAdmine(admId);
        ArrayList<User> arr = fs.getAllStudent();
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);




        if(user.getRole()==0){
            /*
             * 为管理员
             * */
            req.setAttribute("arr",arr);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }else if(user.getRole()==1){
            ArrayList<Major> studentUser = fs.getPersonFile(Integer.toString(user.getU_id()));
            req.setAttribute("arr",studentUser);
            req.getRequestDispatcher("StudentPage.jsp").forward(req,resp);
        }else if(user.getRole()==2){
            req.setAttribute("user",user);
            req.setAttribute("arr",arr);

            /*
             * 获取所有管理员
             * */

            req.getRequestDispatcher("admine.jsp").forward(req,resp);

        }













    }
}
