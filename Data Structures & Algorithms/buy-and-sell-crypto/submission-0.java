// TC: O(n)
// SC: O(n)

class Solution {
    public int maxProfit(int[] prices) {
        // Logic:
        // 1. Create a suffix array to max stock value from future
        // 2. Now cal diff, acc update mProfit

        int mProfit = 0;
        int n = prices.length;
        int[] suffix = new int[n];

        for(int i=n-1; i>=0; i--){
            if(i == n-1){
                suffix[i] = prices[i];
            }else{
                suffix[i] = Math.max(prices[i], suffix[i+1]);
            }
        }

        for(int i=0; i<=n-1; i++){
            int diff = suffix[i] - prices[i];
            mProfit = Math.max(mProfit, diff);
        }

        return mProfit;
    }
}
