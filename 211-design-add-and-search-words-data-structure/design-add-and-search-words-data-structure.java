class Node{
    Node child[];
    boolean eow;
    Node(){
        child=new Node[26];
        eow=false;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
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
    public boolean searchUtil(String word,Node root){
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            char ch=word.charAt(i);
            if(ch=='.'){
               for(int j=0;j<26;j++){
                if(root.child[j]!=null){
                    if(searchUtil(word.substring(i+1),root.child[j])) return true;
                }
               }
               return false;
            }
            else{
                if(root.child[index]==null){
                    return false;
                }
                root=root.child[index];
            }
           
        }
         return root.eow;
    }
    public boolean search(String word) {
        Node curr=root;
        return searchUtil(word,curr);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */