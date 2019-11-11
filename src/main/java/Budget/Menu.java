package Budget;

public class Menu {


    public static void wybierZMenu(int wybor){
        switch(wybor){
            case 1:
                WydatekPrzychod.addIncome();
                break;

            case 2:
                WydatekPrzychod.addPurchase();
                break;

            case 3:
                WydatekPrzychod.showListOfPurchases();
                break;

            case 4:
                WydatekPrzychod.printBalance();
                break;

            case 0:
                System.out.println("\nBye!");
                System.exit(0);
                break;

        }
    }

    public static void wypiszMenu(){
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");
    }


}
