public class Node{
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key,int value){
      this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
    
}
class LRUCache {
     int capacity;
     HashMap<Integer,Node>cache;
    Node left;
    Node right;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        left=new Node(0,0);
        right=new Node(0,0);
        left.next=right;
        right.prev=left;
    }
    
    public void delete(Node node){
        Node nodePrev=node.prev;
        Node nodeNext=node.next;
        nodeNext.prev=nodePrev;
        nodePrev.next=nodeNext;
    }
    
    public void insert(Node node){
        Node rightPrev=this.right.prev;
        rightPrev.next=node;
        node.prev=rightPrev;
        node.next=this.right;
        this.right.prev=node;
        
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            //value of associated key that is a node type 
            Node node=cache.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
             delete(cache.get(key));
        }
        Node newNode =new Node(key,value);
        insert(newNode);
        cache.put(key,newNode);
        
        if(cache.size()>capacity){
             Node lru=this.left.next;
            delete(lru);
            cache.remove(lru.key);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */