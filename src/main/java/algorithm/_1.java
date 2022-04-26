package algorithm;

/**
 * @author Dan.L
 * @date 2022年04月26日9:52 AM
 * <p>
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2 31,2 31−1]。本题中，如果除法结果溢出，则返回 2 31− 1
 * <p>
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 */
public class _1 {

    public static void main(String[] args) {
        int a = 2147483647, b = 3;
        System.out.println(divide(a, b));
    }

    public static int divide(int a, int b) {
        // 1. 判断
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        // 2. 取负数
        int flag = 1;
        if (a > 0) {
            flag--;
            a = -a;
        }

        if (b > 0) {
            flag--;
            b = -b;
        }
        final int result = divCore(a, b);

        // 3. 减法处理
        return flag == 0 ? -result : result;
    }

    public static int divCore(int a, int b) {
        int result = 0;
        while (a <= b) {
            int value = b;
            int code = 1;
            while (value >= 0xc0000000 && a <= value + value) {
                code += code;
                value += value;
            }
            result += code;
            a -= value;
        }

        return result;
    }
}
