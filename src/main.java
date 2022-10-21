import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

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
        float mnoj = 0f;
        if (operator.contains("*")){
            mnoj = Float.parseFloat(operand.get(operator.indexOf("*")));
            try {
                mnoj *=  Float.parseFloat(operand.get(operator.indexOf("*")+1));
                operand.add(Integer.parseInt(operand.get(operator.indexOf("*"))),String.valueOf(mnoj));
            } catch (IndexOutOfBoundsException exc){
                mnoj *=  Float.parseFloat(last);
                operand.add(operator.indexOf("*"),String.valueOf(mnoj));
            }
        }
        System.out.println(mnoj + " - mnoj - xueta - " + operand.get(operator.indexOf("*")+1));
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
            System.out.println(sum + " - sum - f - " + f);
        }
//        System.out.println(sum);
//        System.out.println(1+5*2);
    }
}