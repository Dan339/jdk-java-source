package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dan.L
 * @date 2022年05月01日9:04 PM
 *
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 *输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 *
 * 思想
 * 以下标0开头，到下标i为止，所有子数组的和，用hashMap记录。（key是和， value是和）
 * 出现的次数就是 sum-k在map中出现的次数。
 */
public class _10 {
    public static void main(String[] args) {
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        countMap.put(0,1);   // 修正第一次和为k的时候
        for (int i = 0; i< nums.length; i++){
            sum += nums[i];
            count += countMap.getOrDefault(sum - k, 0);
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
