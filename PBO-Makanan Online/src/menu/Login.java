package menu;
import java.util.Scanner;
import static utility.console.clrscr;

public class Login {
    private static final String usernameAdmin1 = "Adminarya";
    private static final String usernameAdmin2 = "Admingusadit";
    private static final String passwordAdmin = "admin";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String username, password;

        System.out.println("============================================");
        System.out.println("||          Program Makanan Online         ||");
        System.out.println("=============================================");

        while(true){
            System.out.println("|| Username : ");
            username = scanner.nextLine();

            if (username.equals(usernameAdmin1) || username.equals(usernameAdmin2)){
                System.out.println("|| Password");
                password = scanner.nextLine();
                if (password.equals(passwordAdmin)){
                    AdminMenu.main(null);
                } else {
                    System.err.println("Password salah!");
                }
            } else {
                    CusMenu.main(null);
            }
        }
    }

}
