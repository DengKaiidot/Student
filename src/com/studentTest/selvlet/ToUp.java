package com.studentTest.selvlet;

import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* "upTo?stuId="+v+"&admId=${user.getU_id()}";
* */
@WebServlet("/upTo")
public class ToUp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String admId = req.getParameter("admId");
        String stuId = req.getParameter("stuId");
        /*
        * 跳到修改界面
        *admId  stuId
        * */
        FileService fs = new FileServiceImpl();
        int role = fs.getAdmine(stuId).getRole();
        req.setAttribute("role",role);
        req.setAttribute("admId",admId);
        req.setAttribute("stuId",stuId);
        req.getRequestDispatcher("upPage.jsp").forward(req,resp);
    }
}
