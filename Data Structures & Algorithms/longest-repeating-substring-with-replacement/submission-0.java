class Solution {
    public int characterReplacement(String s, int k) {
        
        int l=0;
        int[] count = new int[26];
        int max = 0;
        for(int r = 0; r<s.length(); r++) {
            count[s.charAt(r)-'A'] = count[s.charAt(r)-'A'] + 1;
            int curMax = Arrays.stream(count).max()
                            .orElse(0);
            while( r-l+1 - curMax > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            } 

            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
