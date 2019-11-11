package Budget;
import java.text.DecimalFormat;
import java.util.*;

public class WydatekPrzychod {
    static float stanKonta = 0f;
    static List<StringBuilder> listalinijek = new ArrayList<>();


    public static void addIncome(){
        System.out.println("\nEnter income: ");
        Scanner scanner = new Scanner(System.in);
        stanKonta += scanner.nextFloat();
        System.out.println("Income was added!\n");
    }

    public static void printBalance(){
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String balansjakolancuch = decimalFormat.format(stanKonta);
        System.out.println("\nBalance: $" + stanKonta + "\n");
    }

    public static void addPurchase(){
        String tempPurchaseName;
        float tempPrice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter purchase name: ");
        tempPurchaseName = scanner.nextLine();
        System.out.println("Enter its price: ");
        tempPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Purchase was added! \n");
        listalinijek.add(new StringBuilder(tempPurchaseName + " $" + tempPrice));
        stanKonta -= tempPrice;
    }

    public static void showListOfPurchases(){
        if(listalinijek.isEmpty()){
            System.out.println("\nPurchase list is empty\n");
        }else {
            System.out.println("");
            for (StringBuilder linijka : listalinijek) {
                System.out.println(linijka.toString());
            }
            System.out.println("Total sum: $" + liczSume());
        }
    }

    public static double liczSume(){
        StringBuilder cena = new StringBuilder();
        float suma = 0;
        int licznik = 0;
        for(StringBuilder linijka : listalinijek){
            licznik = 0;
            for(int i = 0 ; i < linijka.length() ; i++){
                if(licznik>0){
                    cena.append(linijka.charAt(i));
                }
                if(linijka.charAt(i) == '$')licznik++;
            }
            suma += Float.parseFloat(cena.toString());
            cena.setLength(0);
        }
        System.out.println(cena);

        return suma;
    }
}
