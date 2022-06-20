package com.studentTest.selvlet;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;
import com.studentTest.service.loginService;
import com.studentTest.service.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 回主界面
 *
 * */
@WebServlet("/goMainPage")
public class GoMainPage extends HttpServlet {
    /*
     * 管理员对象
     * 所有学生
     * */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admId = req.getParameter("admId");
        FileService fs = new FileServiceImpl();
        User user = fs.getAdmine(admId);

        //实现登录服务层的业务逻辑层
        loginService l = new loginServiceImpl();

        /*
         * 获取Arr对象
         * */
        System.out.println(user.getRole());
        List<User> arr = fs.getAllStudent();
        ArrayList<Major> studentUser = fs.getPersonFile(Integer.toString(user.getU_id()));
        if (user.getRole() == 0) {
            /*
             * 老师
             * */

            req.setAttribute("user", user);
            req.setAttribute("arr", arr);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);


        } else if (user.getRole() == 1) {
            /*
             * 学生
             * */
            req.setAttribute("user", user);
            req.setAttribute("arr", studentUser);
            req.getRequestDispatcher("StudentPage.jsp").forward(req, resp);
        } else if (user.getRole() == 2) {
            /*
             * 管理员
             * */

            req.setAttribute("user", user);
            req.setAttribute("arr", arr);

            /*
             * 获取所有管理员
             * */

            req.getRequestDispatcher("admine.jsp").forward(req, resp);
        }

    }
}
