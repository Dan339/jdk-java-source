package algorithm;

/**
 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * <p>
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 *
 * @author Dan.L
 * @date 2022年05月10日9:28 PM
 */
public class _17 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        String emp = "";

        if (s.length() < t.length()) {
            return emp;
        }

        int[] count = new int[256];

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        int length = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            count[s.charAt(j)]--;
            while (core(count)) {
                if (j - i + 1 < length) {
                    length = j - i + 1;
                    left = i;
                    right = j;
                }
                // 左边的指针右移
                count[s.charAt(i)]++;
                i++;
            }
        }

        return left == -1 ? emp : s.substring(left, right + 1);
    }

    public static boolean core(int[] count) {
        for (int c : count) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }
}
