class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LRUCache {
    int cap;
    Node left;
    Node right;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
        cache = new HashMap<>();
    }

    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
        cache.remove(node.key);
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            put(node.key, node.val);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        Node next = left.next;
        next.prev = node;
        node.next = next;
        left.next = node;
        node.prev = left;

        cache.put(key, node);
        if(cache.size() > cap){
            remove(right.prev);
        }
    }
}
