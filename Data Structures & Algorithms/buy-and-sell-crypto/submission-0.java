class Solution {
    public int maxProfit(int[] prices) {
        
        int l = 0;
        int r = 1;
        int max = 0;
        int len = prices.length;

        while(r < len) {
            if(prices[l] < prices[r]) {
                int curProfit = prices[r] - prices[l];
                max = Math.max(max, curProfit);
            } else {
                l = r;
            }
            r++;
        }
        return max;
    }
    
}
