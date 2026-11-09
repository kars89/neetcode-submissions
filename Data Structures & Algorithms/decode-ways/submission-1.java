class Solution {
    public int numDecodings(String s) {
        // dp[i] = dp[i+1] + dp[i+2] (condition)
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, 1);

        char[] str = s.toCharArray();
        for(int i = str.length-1; i>=0; i--) {
         if(str[i] == '0'){
            dp[i] = 0;
         } else {
            dp[i] = dp[i+1];
         }
         
         if(i+1 < str.length)
         if((str[i] == '1') || (str[i] == '2' && str[i+1] <= '6') ) {
            dp[i] = dp[i] + dp[i+2];
         }

        }
        return dp[0];
    }
}
