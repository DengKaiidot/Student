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

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 这个是查看个人成绩
        *
        * */
        String studentId = req.getParameter("v");
        FileService fs = new FileServiceImpl();
        ArrayList<Major> studentUser = fs.getPersonFile(studentId);
        req.setAttribute("arr",studentUser);
        req.getRequestDispatcher("scorePage.jsp").forward(req,resp);


    }
}
