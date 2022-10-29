package helpers;

import java.util.Scanner;

public class printScan {
    public static int choice;
    public static void  println(String text) {
        System.out.println(text);
    }
    public static void  print(String text) {
        System.out.print(text);
    }
    public static Scanner scan() {
        return new Scanner(System.in);
    }
}
