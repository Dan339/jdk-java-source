package algorithm;

/**
 * @author Dan.L
 * @date 2022年04月25日9:47 PM
 */

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 思路：
 *  当指针p1和指针p2之间的子数组之和小于k的时候，向右移动p2。
 *  当指针p1和指针p2之间的子数组之和大于k的时候，向右移动p1。
 */
public class _8 {
    public static void main(String[] args) {
        int target = 7;
        int [] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;   // 指针起始位置
        int sum = 0;  // 位于两个指针之间的子数组中所有数字的和
        int minLength = Integer.MAX_VALUE;
        for(int right =  0; right < nums.length ; right++){
            sum += nums[right];  // sum = sum + num[right]
            while(left <= right && sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];  // sum = sum - num[left]
                left ++ ; //左移
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
