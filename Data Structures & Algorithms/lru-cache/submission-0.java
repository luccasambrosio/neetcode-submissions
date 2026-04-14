class Node{
    int key, val;
    Node prev, next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        prev = next = null;
    }
}

class LRUCache {
    int cap;
    Map<Integer, Node> cache;
    Node left, right;
    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) remove(cache.get(key));
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size() > cap){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
