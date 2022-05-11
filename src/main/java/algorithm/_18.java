package algorithm;

/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 *
 * @author Dan.L
 * @date 2022年05月10日10:30 PM
 */
public class _18 {

    public static void main(String[] args) {
        final boolean a = Character.isLetterOrDigit('-');
        System.out.println(a);
    }

    public static boolean isPalindrome(String s) {
        // 定义两个指针
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)){  // 判断字符是不是数字和字母
                left++;
            }else if(!Character.isLetterOrDigit(rightChar)){
                right--;
            }else {
                char leftToLower = Character.toLowerCase(leftChar);  // 忽略字符串的大小写
                char rightToLower = Character.toLowerCase(rightChar);
                if(leftToLower != rightToLower){
                    return false;
                }
                left++;
                right--;
            }

        }

        return true;
    }
}
