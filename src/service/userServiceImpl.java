package service;

import dao.userDAO;
import model.User;

import java.util.List;

public class userServiceImpl implements userService {
    @Override
    public List<User> getUsers() {
        userDAO userDao = new userDAO();
        return userDao.getUsers();
    }
}
