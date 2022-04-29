package algorithm;

/**
 * @author Dan.L
 * @date 2022年04月26日8:30 PM
 */
public class PriceTest {

    public static void main(String[] args) {

    }

    public static int[] test(int[] prices, int target) {
        int[] result = new int[prices.length];
        for (int i = 0; i <= prices.length; i++) {
            if (target % prices[i] == 0) {
                result[i] = target / prices[i];
                return result;
            }
            if (target < prices[i]) {
                throw new RuntimeException(prices[i] + "大于" + target);
            }
        }


        for (int i = 0; i <= prices.length; i++) {
            int sum = 0;

            while (sum < target) {
                sum += prices[i];
                result[i]++;
            }
            if (sum == target) {
                return result;
            }
            sum -= prices[i];
            result[i]--;
        }
        return result;
    }
}
