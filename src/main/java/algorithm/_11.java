package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dan.L
 * @date 2022年05月01日9:32 PM
 *
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 *
 * 可以考虑将0换为-1，一个子数组减去另一个子数组等于 k
 */
public class _11 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // 虚拟角标 -1
        int count = 0;
        int sum = 0;
        for (int i = 0; i< nums.length; i++){
            final int _num = nums[i] == 0 ? -1 : 1;
            sum += _num;
            if(map.containsKey(sum)){
                count = Math.max(count, i- map.get(sum)) ;  // 找最长的长度
            }else{
                map.put(sum, i);

            }
        }
        return count;
    }
}
