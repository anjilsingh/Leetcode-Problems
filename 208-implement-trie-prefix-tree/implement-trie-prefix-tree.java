class Node{
    Node child[];
    boolean eow;
    Node(){
        child=new Node[26];
        eow=false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';

            if(curr.child[index]==null){
                curr.child[index]=new Node();
            }
            if(i==word.length()-1){
                curr.child[index].eow=true;
            }

            curr=curr.child[index];
        }
    }
    
    public boolean search(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.child[index]==null) return false;

            curr=curr.child[index];
        }
        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(curr.child[index]==null) return false;
            curr=curr.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */