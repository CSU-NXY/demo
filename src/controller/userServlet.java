package controller;

import model.User;
import service.userService;
import service.userServiceImpl;

import java.io.IOException;
import java.util.List;

public class userServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.setCharacterEncoding("UTF8");
        userService userService = new userServiceImpl();
        List<User> userList = userService.getUsers();

    }
}
