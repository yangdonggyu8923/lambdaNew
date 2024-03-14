package com.james.api.user;

import com.james.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private PreparedStatement pstmt;
    private Connection connection;
    private ResultSet rs;


    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static UserRepository instance;

    public UserRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jamesdb", "james", "password");
        pstmt = null;
        rs = null;
    }

    public static UserRepository getInstance() {
        return instance;
    }


    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        List<User> ls = new ArrayList<>();
        String sql = "select * from users";
        pstmt = connection.prepareStatement(sql);

        if (rs.next()) {
            do {
                ls.add(User.builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .height(rs.getDouble("height"))
                        .weight(rs.getDouble("weight"))
                        .build());
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }
        return ls;
    }

    public User findUser() {
        return null;
    }

    public Messenger deleteTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS users;";
        pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20),\n" +
                "    password VARCHAR(20),\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ");";
        pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger insertData(User user) throws SQLException {
        String sql = "insert into users(username,password,name,phone,job,height,weight) \n" +
                "values (?,?,?,?,?,?,?);";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getJob());
        pstmt.setDouble(6, user.getHeight());
        pstmt.setDouble(7, user.getWeight());
        return (pstmt.executeUpdate() == 1) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public void sqlClose() throws SQLException {
        connection.close();
    }


}
