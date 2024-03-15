package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger createMenuTable() throws SQLException;
    Messenger deleteMenuTable() throws SQLException;
    void insertMenus() throws SQLException;

    List<?> selectTable() throws SQLException;

    Messenger returnMessenger() throws SQLException;
}
