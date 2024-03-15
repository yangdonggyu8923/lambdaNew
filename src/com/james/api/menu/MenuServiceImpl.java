package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.sql.SQLException;

public class MenuServiceImpl implements MenuService{
    private static MenuServiceImpl instance = new MenuServiceImpl();

    public static MenuServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Messenger insertMenuData(Menu menu) throws SQLException {
        return null;
    }

    @Override
    public Messenger createMenuTable() throws SQLException {
        return null;
    }

    @Override
    public Messenger deleteMenuTable() throws SQLException {
        return null;
    }
}
