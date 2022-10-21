import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String vvod;
        vvod = sc.nextLine();
        Pattern pattern = Pattern.compile("[+\\-*/=()]");
        Matcher matcher = pattern.matcher(vvod);
        ArrayList<String> operator = new ArrayList<>();
        ArrayList<String> operand = new ArrayList<>();
        int prev = 0, i = 0;
        String last = null;
        while (matcher.find()) {
            operator.add(i, vvod.substring(matcher.start(), matcher.end()));
            operand.add(i, vvod.substring(prev, matcher.start()));
//            System.out.printf("Num: '%s', znak: '%s'\n", operand.get(i), operator.get(i));
            prev = matcher.end();
            i++;
        }
        if (prev > 0 && prev < vvod.length()) {
            last = vvod.substring(prev, vvod.length());
//            System.out.printf("last: %s\n", last);
        }
        //блок математики
        // приоритет умножения
        float mnoj = 0f;
        while (operator.contains("*")) {
            mnoj = Float.parseFloat(operand.get(operator.indexOf("*")));
            try {
                mnoj *= Float.parseFloat(operand.get(operator.indexOf("*") + 1));
                operand.add(operator.indexOf("*") + 1, String.valueOf(mnoj));
                operand.remove(operator.indexOf("*"));
                operand.remove(operator.indexOf("*") + 1);
                operator.remove(operator.indexOf("*"));
            } catch (IndexOutOfBoundsException exc) {
                mnoj *= Float.parseFloat(last);
                operand.add(operator.indexOf("*") + 1, String.valueOf(mnoj));
                operand.remove(operator.indexOf("*"));
//                operand.remove(operator.indexOf("*")+1);
                operator.remove(operator.indexOf("*"));
            }
        }
        // приоритет деления
        float del = 0f;
        while (operator.contains("/")) {
            del = Float.parseFloat(operand.get(operator.indexOf("/")));
            try {
                del /= Float.parseFloat(operand.get(operator.indexOf("/") + 1));
                operand.add(operator.indexOf("/") + 1, String.valueOf(del));
                operand.remove(operator.indexOf("/"));
                operand.remove(operator.indexOf("/") + 1);
                operator.remove(operator.indexOf("/"));
            } catch (IndexOutOfBoundsException exc) {
                del /= Float.parseFloat(last);
                operand.add(operator.indexOf("/") + 1, String.valueOf(del));
                operand.remove(operator.indexOf("/"));
//                operand.remove(operator.indexOf("/")+1);
                operator.remove(operator.indexOf("/"));
            }
        }
        //System.out.println(operand + " " + operator); // показ конечного массива после преобразований
        //System.out.println(mnoj + " - mnoj - del - "+ del);
        float sum = Float.parseFloat(operand.get(0));
        for (int f = 0; f < operator.size(); f++) {
            if (operator.get(f).equals("+")) {
                try {
                    sum += Float.parseFloat(operand.get(f + 1));
                } catch (IndexOutOfBoundsException exc) {
                    assert last != null;
                    sum += Float.parseFloat(last);
                }
            }
            if (operator.get(f).equals("-")) {
                try {
                    sum -= Float.parseFloat(operand.get(f + 1));
                } catch (IndexOutOfBoundsException exc) {
                    sum -= Float.parseFloat(last);
                }
            }
            if (operator.get(f).equals("*")) {
                try {
                    sum *= Float.parseFloat(operand.get(f + 1));
                } catch (IndexOutOfBoundsException exc) {
                    sum *= Float.parseFloat(last);
                }
            }
            if (operator.get(f).equals("/")) {
                try {
                    sum /= Float.parseFloat(operand.get(f + 1));
                } catch (IndexOutOfBoundsException exc) {
                    sum /= Float.parseFloat(last);
                }
            }
//            System.out.println(sum + " - sum - f - " + f);
        }
        if (sum != 1.1/0) {
            System.out.println(sum);
        } else {
            System.out.println("Косяк, законы данной вселенной запрещает делить на ноль");
        }
    }
}