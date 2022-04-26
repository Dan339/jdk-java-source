package algorithm;

/**
 * @author Dan.L
 * @date 2022年04月26日2:31 PM
 * <p>
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "10"
 * 输出: "101"
 */
public class _2 {
    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;

        int tmp = 0;  // 进位值

        while (aLength >= 0 || bLength >= 0) {
            int aSum = 0;
            int bSum = 0;
            if (aLength >= 0) {
                aSum = a.charAt(aLength) - '0';
                aLength--;
            }
            if (bLength >= 0) {
                bSum = b.charAt(bLength) - '0';
                bLength--;
            }

            int sum = aSum + bSum + tmp;

            tmp = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;

            result.append(sum);
        }

        if(tmp == 1){
            result.append(1);
        }

        return result.reverse().toString();
    }
}
