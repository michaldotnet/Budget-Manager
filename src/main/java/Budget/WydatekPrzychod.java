package Budget;
import java.text.DecimalFormat;
import java.util.*;
import Repository.MapaTypow;

public class WydatekPrzychod {
    static float stanKonta = 0f;
    static List<Wydatek> listalinijek = new ArrayList<>();


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
        int typ;
        String tempPurchaseName;
        float tempPrice;
        typ = chooseType();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter purchase name: ");
        tempPurchaseName = scanner.nextLine();
        System.out.println("Enter its price: ");
        tempPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Purchase was added! \n");
        listalinijek.add(new Wydatek(new StringBuilder(tempPurchaseName + " $" + tempPrice), typ));
        stanKonta -= tempPrice;
    }

    public static void showListOfPurchases(){
        int typ;
        if(listalinijek.isEmpty()){
            System.out.println("\nPurchase list is empty\n");
        }else {
            System.out.println("Choose the type of purchase: \n1) Food \n2) Clothes \n3) Entertainment \n4) Other \n5) All");
            Scanner scanner = new Scanner(System.in);
            typ = scanner.nextInt();
            System.out.println("");
            System.out.println(MapaTypow.mapaTypowZakupow.get(typ));
            for (Wydatek linijka : listalinijek) {
                if(typ==5) // jesli typ rowna sie 5 to znaczy ze chodzi o wszystkie typy
                System.out.println(linijka.getLinijka().toString());

                else{
                    if(typ == linijka.getTyp()) System.out.println(linijka.getLinijka().toString());
                }
            }
            System.out.println("Total sum: $" + liczSume(typ));
        }
    }

    public static double liczSume(int typ){
        StringBuilder cena = new StringBuilder();
        float suma = 0;
        int licznik = 0;
        for(Wydatek linijka : listalinijek){

            licznik = 0;
            for(int i = 0 ; i < linijka.getLinijka().length() ; i++){
                if(licznik>0){
                    cena.append(linijka.getLinijka().charAt(i));
                }
                if(linijka.getLinijka().charAt(i) == '$')licznik++;
            }
            if(typ == linijka.getTyp() || typ == 5) {
                suma += Float.parseFloat(cena.toString());
            }
            cena.setLength(0);
        }
        return suma;
    }

    public static int chooseType(){
        int temp;
        do {
            System.out.println("Choose the type of purchase: \n1) Food \n2) Clothes \n3) Entertainment \n4) Other");
            Scanner scanner = new Scanner(System.in);
            temp = scanner.nextInt();
        }while(!MapaTypow.mapaTypowZakupow.containsKey(temp));
        return temp;
    }
}
