import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        /*String vvod;
        System.out.println("Hello i'm calk vvodi primer");
        Scanner sc = new Scanner(System.in);
        vvod = sc.nextLine();
        String[] numbers =   vvod.split("[-+/*]");
        int[] num = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(Arrays.toString(num));*/
        Scanner sc = new Scanner(System.in);
        String vvod = "-5+4*(44-5)";
        vvod = sc.nextLine();
        Pattern pattern = Pattern.compile("[+\\-*/=()]");
        Matcher matcher = pattern.matcher(vvod);
        ArrayList<String> operator = new ArrayList<>();
        ArrayList<String> operand = new ArrayList<>();
        int prev = 0, i = 0;
        String last = null;
        while(matcher.find()) {
            operator.add(i, vvod.substring(matcher.start(), matcher.end()));
            operand.add(i, vvod.substring(prev, matcher.start()));
            System.out.printf("Num: '%s', znak: '%s'\n", operand.get(i), operator.get(i));
            prev = matcher.end();
            i++;
        }
        if(prev > 0 && prev < vvod.length()) {
           last = vvod.substring(prev, vvod.length());
            System.out.printf("last: %s\n", last);
        }
        //блок математики
        float sum = Float.parseFloat(operand.get(0));
        for(int f = 0; f < operand.size(); f++){
            if (operator.get(f).equals("+")) {
                try {
                    sum += Float.parseFloat(operand.get(f+1));
                } catch (IndexOutOfBoundsException exc){
                    sum += Float.parseFloat(last);
                }
            }
            if (operator.get(f).equals("-")) {
                try {
                    sum -= Float.parseFloat(operand.get(f+1));
                } catch (IndexOutOfBoundsException exc){
                    sum -= Float.parseFloat(last);
                }
            }
            if (operator.get(f).equals("*")) {
                try {
                    sum *= Float.parseFloat(operand.get(f+1));
                } catch (IndexOutOfBoundsException exc){
                    sum *= Float.parseFloat(last);
                }
            }
            if (operator.get(f).equals("/")) {
                try {
                    sum /= Float.parseFloat(operand.get(f+1));
                } catch (IndexOutOfBoundsException exc){
                    sum /= Float.parseFloat(last);
                }
            }

        }
        System.out.println(sum);
//        System.out.println(1+5*2);
    }
}