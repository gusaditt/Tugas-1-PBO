package utility;
import java.util.*;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    public static int inputInt(String message){
        int number;
        System.out.println(message);
        System.out.print("|| ");
        while (!sc.hasNextInt()) {
            System.err.println("Masukkan hanya angka");
            sc.next();
        }
        number = sc.nextInt();
        sc.nextLine();
        return number;
    }


    public static int inputInt(String message,int lowerLimit){
        int number;
        while (true){
            System.out.println(message);
            System.out.print("|| ");
            while (!sc.hasNextInt()) {
                System.err.println("Masukkan hanya angka");
                sc.next();
            }
            number = sc.nextInt();


            if (number >= lowerLimit) {
                break;
            }
            System.err.println("Pilihan tidak tersedia ");
        }
        sc.nextLine();
        return number;
    }
}
