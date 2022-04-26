package algorithm;

/**
 * @author Dan.L
 * @date 2022年04月26日2:55 PM
 * <p>
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * <p>
 * 思路：i&(i-1)中1的算个数要比i的1的个数少1
 */
public class _3 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        final int[] ints = countBits(2);
        for (int i = 0; i < ints.length; i++) {
            builder.append(ints[i]);
        }
        System.out.println(builder.toString());
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
