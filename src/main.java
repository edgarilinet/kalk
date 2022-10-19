import java.util.Arrays;
import java.util.Scanner;

public class main {

    /*public static void main(String[] args) {
        float vvod1 = 0, vvod2 = 0, result = 0;
        String deistvie = "0";
        boolean testDeistvie = false;
        System.out.println("Hello, i'm Calc");
        Scanner sc = new Scanner(System.in);
        vvod1 = sc.nextFloat();
        deistvie = proverkaZnakaDeistvie(deistvie, testDeistvie, sc);
        vvod2 = sc.nextFloat();
        switch (deistvie) {
            case ("+") -> result = vvod1 + vvod2;
            case ("-") -> result = vvod1 - vvod2;
            case ("*") -> result = vvod1 * vvod2;
            case ("/") -> result = vvod1 / vvod2;
        }
        if (vvod1 != 0 & vvod2 == 0 & deistvie.equals("/")){
            System.out.println("Na 0 delit' nelzya");
        } else if (vvod1 == 0 & vvod2 == 0 & deistvie.equals("/")){
            result = 1;
            System.out.println(result);
        } else {
            System.out.println(result);
        }

    }
    public static boolean znakDeistvie(String deistvie) {
        boolean testDeistvie;
        if (deistvie.equals("+") | deistvie.equals("-") | deistvie.equals("*") | deistvie.equals("/")){
            testDeistvie = true;
            //System.out.println("1"+testDeistvie);
        } else {
            testDeistvie = false;
            //System.out.println("2"+testDeistvie);
        }
        return testDeistvie;
    }
    }*/

    public static void main(String[] args) {
        String vvod;
        System.out.println("Hello i'm calk vvodi primer");
        Scanner sc = new Scanner(System.in);
        vvod = sc.nextLine();
        String[] numbers =   vvod.split("[-+/*]");
        int[] num = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(Arrays.toString(num));

    }
/*    public static int[] allNumbers(String vvod){

        System.out.println(num);
        return;
    }*/


}