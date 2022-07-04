package algorithm;

/**
 * \    4. 有一组数字，数字从左到右特征是从大到小然后从大到小，数组中可能会出现连续的数字。输出最大的数字和个数。有重复。
 *
 * @author Dan.L
 * @date 2022年06月15日18:01
 */

public class test2 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 3, 4, 5, 6, 7, 8,8,8,8,8,9,10,10,11,11,12,23,33,33,10,2,2,2,2,2,2,1,1,1};
        int max = middle(array, 0, array.length - 1);
        int num = findNum(array, max);
        System.out.println("数组最大数字" + max + ",最大元素的个数：" + num);
    }

    //找到找到最大值,从第一位开始，然后最后一位结束
    private static int middle(int[] array, int left, int right) {

        // 拆数组，拆到只剩一个
        int mid = left + ((right - left) >> 1);

        if (left == right) {
            return array[left];
        }

        // 递归取最左的
        int left_max = middle(array, left, mid);
        int right_max = middle(array, mid + 1, right);

        return Math.max(left_max, right_max);
    }

    //查看最大元素的个数有多少个。
    private static int findNum(int[] array, int max) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                num++;
            }
        }
        return num;
    }
}

