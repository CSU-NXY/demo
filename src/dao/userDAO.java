package dao;

import model.User;
import service.DBUtil;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class userDAO {
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, username, age, description FROM user";
        Statement stmt = null;
        ResultSet rs = null;
        DBUtil dbUtil = new DBUtil();
        try{
            stmt = dbUtil.connect();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setAge(rs.getInt("age"));
                user.setDescription("description");
                userList.add(user);
            }
            dbUtil.close();
            rs.close();
        }catch (Exception e) {
            System.out.print(e.toString());
        }
        return userList;
    }
}
