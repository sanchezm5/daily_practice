/** This question is from LeetCode

 Say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the
 maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock
 multiple times). Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

 Input: [7,1,5,3,6,4]       Output: 7
 Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

 Input: [1,2,3,4,5]         Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 engaging multiple transactions at the same time. You must sell before buying again.

 Input: [7,6,4,3,1]         Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

package arrays;

// Time Complexity: O(n) | Space Complexity: O(1)
public class BestTimeToBuyAndSellStockII {

    // Helper method to check if array is already sorted
    public static boolean arrayIsSorted(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        // if the array is empty or 0, return 0 for the profit
        if (prices.length < 2) return 0;

        // if the array is sorted the profit is equal to difference between the last and first elements in the array
        if (arrayIsSorted(prices)) {
            profit = prices[prices.length - 1] - prices[0];
            return profit;
        }

        // compare the ith price to the next
        // if it is less than the next, the profit is the difference between the two values
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        // finally return the maximum profit
        return profit;
    }

    public static void main(String[] args) {
        // BestTimeToBuyAndSellStockII
        int[] a = {5};
        System.out.println("The maximum profit for [5] is " + maxProfit(a));
        int[] b = {1,9,6,9,1,7,1,1,5,9,9,9};
        System.out.println("The maximum profit for [1,9,6,9,1,7,1,1,5,9,9,9] is " + maxProfit(b));
        int[] c = {1,2,3,4,5};
        System.out.println("The maximum profit for [1,2,3,4,5] is " + maxProfit(c));
        int[] d = {4,3,1};
        System.out.println("The maximum profit for [4,3,1] is " + maxProfit(d));
    }
}
