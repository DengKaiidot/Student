package com.studentTest.selvlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePassword")
public class ToUpdatePassword extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // window.location.href = "updatePassword?upId=${user.getU_id()}&admId=${user.getU_id()}";
        String id= req.getParameter("upId");
        String admId = req.getParameter("admId");
        req.setAttribute("upid",id);
        req.setAttribute("mainid",admId);
        req.getRequestDispatcher("updatePassword.jsp").forward(req,resp);

    }
}
