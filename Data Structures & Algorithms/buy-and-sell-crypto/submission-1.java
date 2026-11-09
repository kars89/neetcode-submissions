class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) {
            return 0;
        }
        int maxProfit = 0;
        int buy = 0;
        for(int i=1; i<len; i++) {
            int curProfit =  prices[i] - prices[buy];

            if(curProfit > maxProfit) {
                maxProfit = curProfit;
            }
            if(prices[buy] > prices[i]) {
                buy = i;
            }
        }
        return maxProfit;
    }
}
