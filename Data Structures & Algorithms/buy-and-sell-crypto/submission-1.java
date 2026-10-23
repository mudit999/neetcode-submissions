// TC: O(n)
// SC: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        // Logic:
        // 0. Traverse the array
        // 1. Cal profit each day based on minPrice
        // 2. Then update the maxProfit
        // 3. Keep track of minPrice we can buy

        int mProfit = 0;
        int minBuy = prices[0];

        for(int price : prices){
            int currProfit = price - minBuy;
            mProfit = Math.max(mProfit, currProfit);
            minBuy = Math.min(minBuy, price);
        }
        return mProfit;
    }
}
