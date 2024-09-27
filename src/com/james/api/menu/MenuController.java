package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuController{
    MenuServiceImpl menuService;

    public MenuController() {
        this.menuService = MenuServiceImpl.getInstance();
    }

    private static MenuController instance = new MenuController();

    public static MenuController getInstance() {
        return instance;
    }

    public Messenger createMenuTable() throws SQLException {
        return menuService.createMenuTable();
    }

    public Messenger deleteMenuTable() throws SQLException {
        return menuService.deleteMenuTable();
    }

    public void insertMenus() throws SQLException {
        menuService.insertMenus();
    }

    public List<?> selectTable() throws SQLException {
        return menuService.selectTable();
    }
}
