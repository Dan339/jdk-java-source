package algorithm;

/**
 * @author Dan.L
 * @date 2022年05月01日11:27 AM
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 *
 */
public class _9 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        long sum = 1;  // 乘积之和
        int left = 0;  // 移动p1 指针
        int count = 0;
        for(int right = 0; right < nums.length; right ++){
            sum = sum * nums[right];
            while (left <= right && sum >= k){
                sum = sum / nums[left];   // 移动p2指针
                left++;
            }

            if(right >= left){
                count += right - left + 1;  // 算个数
            }else {
                count = 0;
            }
        }
        return count;
    }

}
