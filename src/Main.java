import com.james.api.enums.Navigation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(Navigation.navigate(sc));
    }
}
