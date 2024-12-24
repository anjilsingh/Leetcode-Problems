public class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key,int val){
        this.key=key;
        this.val=val;
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
        this.left=new Node(0,0);
        this.right=new Node(0,0);     
        this.left.next=right;
        this.right.prev=left;
    }
    public void delete(Node node){
        Node nodeNext=node.next;
        Node nodePrev=node.prev;
        nodePrev.next=nodeNext;
        nodeNext.prev=nodePrev;
        cache.remove(node);
    }
    
    public void insert(Node node){
      Node prev=this.right.prev;
      prev.next=node;
      node.prev=prev;
      node.next=this.right;
      this.right.prev=node;
        
    }
    public int get(int key) {
        if(cache.containsKey(key)){
          Node node=cache.get(key);
          delete(node);
          insert(node);
          return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
          delete(cache.get(key));
        }
        Node newNode=new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);
        
        if (cache.size() > capacity) {
            Node lru = this.left.next;
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