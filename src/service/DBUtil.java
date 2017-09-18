package service;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;

public class DBUtil {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/demo";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    Connection conn = null;
    Statement stmt = null;

    public Statement connect() throws ServletException, IOException {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        } if (stmt != null) {
            stmt.close();
        }
    }
}
