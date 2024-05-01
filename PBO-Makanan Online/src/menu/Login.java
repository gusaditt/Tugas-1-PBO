package menu;
import java.util.Scanner;
import static utility.console.clrscr;

public class Login {
    private static final String usernameAdmin1 = "arya";
    private static final String usernameAdmin2 = "gusadit";
    private static final String passwordAdmin = "admin";
    private static final String passwordCustomer = "user123";

    public static void main(String[] args){
        clrscr();
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
            } else if (username.equals("customer")) {
                CusMenu.main(null);
            } else {
                System.out.println("Username tidak ditemukan!");
            }
        }
    }

}
