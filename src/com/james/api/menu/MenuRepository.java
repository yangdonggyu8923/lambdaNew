package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository{
    private PreparedStatement pstmt;
    private Connection connection;
    private ResultSet rs;

    public MenuRepository() throws SQLException {
        pstmt = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jamesdb", "james", "password");
        rs = null;
    }

    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MenuRepository getInstance() {
        return instance;
    }

    public Messenger createMenuTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS menus (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    item VARCHAR(20),\n" +
                "    category VARCHAR(20)\n" +
                ");";
        pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }


    public Messenger deleteMenuTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS menus;";
        pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger insertMenus(Menu menu) throws SQLException {
        String sql = "insert into menus(item, category) values (?, ?);";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, menu.getItem());
        pstmt.setString(2, menu.getCategory());
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public List<Menu> selectTable() throws SQLException {
        List<Menu> ls = new ArrayList<>();
        String sql = "select * from menus where category = 'navigate'";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("category"))
                        .build());
            } while (rs.next());
        } else {
            System.out.println("카테고리가 없습니다.");}
        return ls;
    }
}