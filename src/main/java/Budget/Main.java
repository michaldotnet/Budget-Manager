package Budget;

import java.util.*;

public class Main {

    static int wybierz;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.wypiszMenu();
            wybierz = scanner.nextInt();
            Menu.wybierZMenu(wybierz);
        }
    }
}

