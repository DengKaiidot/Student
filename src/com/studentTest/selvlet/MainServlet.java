package com.studentTest.selvlet;

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

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String v = req.getParameter("v");

        FileService fs = new FileServiceImpl();
        User u = fs.getFileByNameOrId(v);
        ArrayList<User> arr = new ArrayList<>();

        String id = req.getParameter("id");
        FileService fs2 = new FileServiceImpl();
        User admineU = fs2.getAdmine(id);
        req.setAttribute("user", admineU);
        if(u==null){
            arr=fs.getAllStudent();
        }else{
            arr.add(u);
        }



        if (admineU.getRole() == 0) {
            req.setAttribute("arr", arr);
            req.getRequestDispatcher("mainPage.jsp").forward(req, resp);
        } else if (admineU.getRole() == 2) {
            req.setAttribute("arr", arr);
            req.getRequestDispatcher("admine.jsp").forward(req, resp);
        } else {
            System.out.println("--------------------");
        }
    }
}