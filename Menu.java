package Robot_Fight;

import java.util.Scanner;

    public class Menu {
        public static String getStringFromConsole() {
            Scanner scanner = new Scanner(System.in);
            try {
                String str = scanner.next();
                return str;
            }catch (Exception e){
                return null;
            }
        }
        public static char getCharFromConsole() {
            Scanner scanner = new Scanner(System.in);
            char temp = 'P';
            System.out.println("");
            System.out.println("*Only first character is processed!*");
            try {
                char str = scanner.next().toUpperCase().charAt(0);
                return str;
            }catch (Exception e){
                return temp;
            }
        }

}
