import java.util.ArrayList;
import java.util.LinkedList;
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

    public static String proverkaZnakaDeistvie(String deistvie, boolean testDeistvie, Scanner sc){
        deistvie = sc.next();
        testDeistvie = znakDeistvie(deistvie);
        //System.out.println(testDeistvie);
        while (!testDeistvie){
            //System.out.println(testDeistvie);
            System.out.println("Vvedite deistvie ");
            deistvie = sc.next();
            testDeistvie = znakDeistvie(deistvie);
        }
        //System.out.println(deistvie);
        return deistvie;
    }*/
    public static void main(String[] args) {
        String deistvie = null, vvod;
        int pervoeChislo = -120, vtoroeChislo = -120, tretieChislo = -120;
        int positionZnak = 0, positionVtoroiZnak = 0 , positionRavno = 0;
        int fromIndex = 0; //от какого числа искать символы
        char[] positionZnakof;
        System.out.println("Hello i'm calk vvodi primer");
        Scanner sc = new Scanner(System.in);
        vvod = sc.next();
        positionZnakof = new char[poiskVsehZnakov(vvod).size()-1];
        for (int i = 1 ; i <= poiskVsehZnakov(vvod).size()-1; i++){
            positionZnakof[i-1] = vvod.charAt(poiskVsehZnakov(vvod).get(i)-1);
            System.out.print(positionZnakof[i-1] + " - ");
            System.out.println();
        }
        fromIndex = positionZnak + 1;
        //System.out.println(fromIndex + " - from index");
        positionRavno = vvod.indexOf('=');
        System.out.println(poiskVsehChisel(vvod));
        System.out.println(poiskVsehZnakov(vvod) + " - arrayList.size()");
    }


    public static int znak ( String vvod, int fromIndex) {
        char[] znaki = {'+','-','*','/'};
        int positionZnak = -1;
        for (int i = 0; i < znaki.length; i++){
            if (positionZnak == -1){
                positionZnak = vvod.indexOf(znaki[i], fromIndex);
            }
        }
        return positionZnak;
    }


    public static ArrayList<Integer> poiskVsehZnakov(String vvod){
        /*нужно найти все знаки которые есть в примере КАК ЭТО СДЕЛАТЬ? 0_0
         а что если найти колличество знаков?
         */
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0,0);
        int  i = 1, k;
        vvod = " " + vvod;
        while (znak(vvod,arrayList.get(i-1) + 1 ) != -1){
            arrayList.add(i, znak(vvod,arrayList.get(i-1) + 1 ));
            //System.out.println(arrayList.get(i) + " - arrayList.get  (i) - " + i);
            i++;
        }
        return (arrayList);
    }

    public static ArrayList<Integer> poiskVsehChisel(String vvod){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i != poiskVsehZnakov(vvod).size(); i++){
            arrayList.add(i-1, poiskVsehZnakov(vvod).get(i));
            System.out.println(arrayList.get(i));
        }
        return arrayList;
    }

    public static int itog(int vvod1, int vvod2, String deistvie){
        int result = 0;
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
        }
        return result;
    }

}