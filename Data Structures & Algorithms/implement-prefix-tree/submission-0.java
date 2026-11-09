class PrefixNode {
    Map<Character, PrefixNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {
    PrefixNode root;
    public PrefixTree() {
        this.root = new PrefixNode();     
    }

    public void insert(String word) {
        PrefixNode cur = this.root;
        for(char c : word.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new PrefixNode());
            }
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        PrefixNode cur = this.root;
        for(char c : word.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                 return false;
            } 
            cur = cur.children.get(c);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        PrefixNode cur = this.root;
        for(char c : prefix.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                 return false;
            } 
            cur = cur.children.get(c);
        }
        return true;
    }
}
