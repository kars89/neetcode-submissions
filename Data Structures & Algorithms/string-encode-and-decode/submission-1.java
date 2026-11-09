class Solution {

    public String encode(List<String> strs) {

        String res = "";
        for(String s : strs) {
            res = res + (s.length()+"#"+s);
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            String count = "";;
            while(str.charAt(i) != '#') {
                count = count + (str.charAt(i));
                i++;
            }
            int countInt = Integer.parseInt(count);
            i++;
            res.add(str.substring(i, i+countInt));
            i = i+ countInt;
        }
        return res;
    }
}
