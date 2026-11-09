class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) { 
        return lcs(text1, text2, 0, 0);
    }

    public int lcs(String text1, String text2, int t1, int t2) {
        if(map.containsKey(t1+"#"+t2)) {
            return map.get(t1+"#"+t2);
        }
        for(int i = t1; i<text1.length(); i++) {
            for(int j = t2; j<text2.length(); j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    int val = 1 + lcs(text1, text2, i+1, j+1);
                    map.put( i+"#"+j, val);
                    return val;
                } else {
                    int l1 = lcs(text1, text2, i+1, j);
                    int l2 = lcs(text1, text2, i, j+1);
                    map.put(i+"#"+j, Math.max(l1, l2));
                    return Math.max(l1, l2);
                }
            }
        }
        return 0;
    }
}
