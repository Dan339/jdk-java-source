package algorithm;

import java.math.BigDecimal;

/**
 * num1 = "123". num2 = "456"
 * sum = ""
 * <p>
 * mum1.length >=1  num2.length <= 200
 *
 * @author Dan.L
 * @date 2022年05月23日9:24 PM
 */
public class 大数乘法 {
    public static void main(String[] args) {
        String a = "23423562623";
        String b = "23423626263";
        String res = test(String.valueOf(a), b + "");
        System.out.println(new BigDecimal(a).multiply(new BigDecimal(b)));
        System.out.println(res);
    }

    private static String test(final String num1, final String num2) {
        String[] jiArray = new String[num2.length()];
        for (int j = 0; j < num2.length(); j++) {
            String ji = null;
            int a = num2.charAt(num2.length() - j - 1) - '0';
            for (int i = 0; i < num1.length(); i++) {
                int b = num1.charAt(num1.length() - i - 1) - '0';
                String zero = "";
                for (int k = 0; k < i + j; k++) {
                    zero = zero + "0";
                }
                ji = add(ji, a * b + zero);
            }
            jiArray[j] = ji;
        }

        String ji = jiArray[0];
        for (int i = 1; i < jiArray.length; i++) {
            ji = add(ji, jiArray[i]);
        }
        return ji;
    }

    private static String add(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num1.length() > num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = num1;
        }
        String sum = null;
        int v = 0;
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(num1.length() - i - 1) - '0';
            int b = num2.charAt(num2.length() - i - 1) - '0';
            int tmp = a + b + v;
            v = tmp / 10;
            tmp = tmp % 10;
            sum = append(String.valueOf(tmp), sum);
        }

        for (int j = num1.length(); j < num2.length(); j++) {
            int a = num2.charAt(num2.length() - j - 1) - '0';
            int tmp = a + v;
            v = tmp / 10;
            tmp = tmp % 10;
            sum = append(String.valueOf(tmp), sum);
        }
        if (v != 0) {
            sum = append(String.valueOf(v), sum);
        }

        return sum;
    }

    private static String append(String a, String b) {
        if (b == null) {
            return a;
        }

        return a + b;
    }
}
