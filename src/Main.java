import com.james.api.enums.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        while (Navigation.navi(sc));

//        String stringFlag = NavigationOfConsumer.navi(sc);
//        while (!stringFlag.navi(sc).equals("x"));

//        String stringFlag1 = NavigationOfFunction.navi(sc);
//        while (!stringFlag1.equals("x"));

//        String stringFlag2 = NavigationOfSupplier.navi(sc);
//        while (!stringFlag2.equals("x"));



    }
}