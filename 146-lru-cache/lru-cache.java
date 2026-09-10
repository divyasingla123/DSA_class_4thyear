class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer,Node> mp;
    int capacity;
    Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        mp=new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))return -1;
        Node node=mp.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;

    }
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            node.value=value;
            remove(node);
            insert(node);
        }
        else{
            if(mp.size()==capacity){
                Node lru=tail.prev;
                remove(lru);
                mp.remove(lru.key);
            }
            Node node=new Node(key,value);
            insert(node);
            mp.put(key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */