package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.sql.SQLException;

public interface MenuService {
    Messenger insertMenuData(Menu menu) throws SQLException;
    Messenger createMenuTable() throws SQLException;
    Messenger deleteMenuTable() throws SQLException;

}
