import com.james.api.menu.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
//      MenuController.getInstance().deleteMenuTable();
        MenuController.getInstance().createMenuTable();
        MenuController.getInstance().insertMenus();

//        while (Navigation.navi(sc));
    }
}