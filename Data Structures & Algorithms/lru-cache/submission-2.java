class Node {
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
        this.cap = capacity;
        cache = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertToHead(Node node){
        Node next = left.next;
        next.prev = node;
        node.next = next;
        left.next = node;
        node.prev = left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
            insertToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
            node.val = value;
            insertToHead(node);
        }else{
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            cache.put(key, newNode);
        }

        if(cache.size() > cap){
            Node lru = right.prev;
            cache.remove(lru.key);
            removeNode(lru);
        }
    }
}
