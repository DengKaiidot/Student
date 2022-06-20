package com.studentTest.selvlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;
import com.studentTest.service.Register;
import com.studentTest.service.RegisterImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/reg")
public class RegServlet extends HttpServlet {
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String a = req.getParameter("a");
            String b = req.getParameter("b");
            String c = req.getParameter("c");
            //register r = new registerImpl();
            Register r = new RegisterImpl();
            User u = new User();
            u.setU_name(a);
            u.setU_phone(b);
            u.setU_pwd(c);
            r.register(u);

            FileService fs = new FileServiceImpl();
            int id = fs.getIdByNamePwd(a,c);
            req.setAttribute("id",id);
            req.setAttribute("name",a);
            req.getRequestDispatcher("regscu.jsp").forward(req,resp);

        }
    }

