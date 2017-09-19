package controller;

import com.alibaba.fastjson.JSON;
import model.User;
import service.userService;
import service.userServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class userServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        userService userService = new userServiceImpl();
        List<User> userList = userService.getUsers();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(JSON.toJSON(userList));
            out.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
