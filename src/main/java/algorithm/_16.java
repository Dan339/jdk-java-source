package algorithm;

import com.sun.tools.javac.util.StringUtils;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Dan.L
 * @date 2022年05月09日10:04 PM
 */
public class _16 {

    public static void main(String[] args) {
        String s = "abcaabcd";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 256个ASCII码
        int[] count = new int[256];

        int i = 0; // 右指针
        int j = 0; // 左指针
        boolean dup = false; // 重复的字母个数
        int maxLength = 0;
        for (; i < s.length(); i++) {
            count[s.charAt(i)]++;
            // 如果有重复值
            if (count[s.charAt(i)] == 2) {
                dup = true;
            }

            if (!dup) { // 如果没有重复字母
                if (i - j + 1 > maxLength) {
                    // 比较当前长度与最大长度的值
                    maxLength = i - j + 1;
                }
            } else {
                while (dup) {
                    count[s.charAt(j)]--;
                    // 移除左指针指向的字母，如果此字母有重复，则降低重复度
                    if (count[s.charAt(j)] == 1) {
                        dup = false;
                    }
                    j++;
                }
            }
        }
        return maxLength;

    }

}
