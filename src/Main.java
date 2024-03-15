import com.james.api.enums.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        while (Navigation.navi(sc));
    }
}