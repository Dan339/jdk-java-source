package algorithm;

/**
 * @author Dan.L
 * @date 2022年05月09日9:31 PM
 * <p>
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 思路：双指针 滑动窗口 哈希表
 */
public class _14 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a'] ++;
        }

        for(int i = 0; i< s2.length(); i++){
            count[s2.charAt(i) - 'a'] --;
            if (i >= s1.length()) {
                count[s2.charAt(i- s1.length())  - 'a']++;
            }
            if(core(count)){
                return true;
            }
        }
        return false;
    }


    public static boolean core(int count[]){
        for(int c : count){
            if(c != 0){
                return false;
            }
        }
        return true;
    }
}


