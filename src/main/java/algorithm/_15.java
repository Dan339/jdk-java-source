package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dan.L
 * @date 2022年05月09日9:51 PM
 * <p>
 * 给定两个字符串s和p，找到s中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 */
public class _15 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            if (i >= p.length()) {
                count[s.charAt(i - p.length()) - 'a']++;
            }
            if (core(count)) {
                result.add(i- p.length() + 1);
            }
        }

        return result;
    }

    public static boolean core(int[] count) {
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
