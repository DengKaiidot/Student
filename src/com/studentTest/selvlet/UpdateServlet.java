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
import java.util.List;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //window.location.href="update?upid="+upid+"&mainid=${mainid}&pwd="+pwd;
        String id=req.getParameter("upid");
        String mainid=req.getParameter("mainid");
        String pwd=req.getParameter("pwd");
        System.out.println(id+" "+mainid+" "+pwd);
        FileService fs = new FileServiceImpl();
        fs.uppwd(id,pwd);
        User user = fs.getAdmine(mainid);
        req.setAttribute("user",user);
        if(user.getRole()==0){
            /*
            * 为管理员
            * */
            List<User> arr = fs.getAllStudent();
            req.setAttribute("arr",arr);
            req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
        }else if(user.getRole()==1){
            ArrayList<Major> studentUser = fs.getPersonFile(Integer.toString(user.getU_id()));
            for(int i=0;i<studentUser.size();i++){
                System.out.println(studentUser.get(i).getA()+"  "+studentUser.get(i).getB());
            }
            req.setAttribute("arr",studentUser);
            req.getRequestDispatcher("StudentPage.jsp").forward(req,resp);
        }else if(user.getRole()==2){
            ArrayList<User> arr = fs.getAllStudent();
            req.setAttribute("user",user);
            req.setAttribute("arr",arr);

            /*
             * 获取所有管理员
             * */

            req.getRequestDispatcher("admine.jsp").forward(req,resp);

        }


    }
}
