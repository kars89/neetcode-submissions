class Solution {
    public int characterReplacement(String s, int k) {
        
        int l=0;
        int[] count = new int[26];
        int max = 0;
        int maxFreq = 0;
        for(int r = 0; r<s.length(); r++) {
            count[s.charAt(r)-'A'] = count[s.charAt(r)-'A'] + 1;
            maxFreq = Math.max(maxFreq, count[s.charAt(r)-'A']);
            while( r-l+1 - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            } 

            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
