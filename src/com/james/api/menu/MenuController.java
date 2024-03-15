package com.james.api.menu;

import com.james.api.enums.Messenger;

import java.sql.SQLException;

public class MenuController{
    MenuServiceImpl menuService;

    public MenuController() {
        this.menuService = MenuServiceImpl.getInstance();
    }

    private static MenuController instance = new MenuController();

    public static MenuController getInstance() {
        return instance;
    }

    public Messenger insertMenuData(Menu menu) throws SQLException {
        return menuService.insertMenuData(menu);
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
}
