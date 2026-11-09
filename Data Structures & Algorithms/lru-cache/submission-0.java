class LRUCache {

    class Node {
        int value;
        int key;

        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    Node head;
    Node tail;

    int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next= node;
    }

    void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
       Node node = cache.get(key);
       if(node == null) {
         return -1;
       }
       
       remove(node);
       addToHead(node);

       return node.value;
    }
    
    public void put(int key, int value) {
       Node node = cache.get(key);
       if(node != null) {
         node.value = value;
         remove(node);
         addToHead(node);
         return;
       } else {
         if(capacity == cache.size()) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
         }
         node = new Node(key, value);
         addToHead(node);
         cache.put(key, node);
       }
       
      
    }
}
