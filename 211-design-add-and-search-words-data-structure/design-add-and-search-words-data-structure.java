class Node{
    Node children[];
    boolean eow=false;

    Node(){
        children=new Node[26];
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

            if(curr.children[index]==null){
             curr.children[index]=new Node();
            }
            if(i==word.length()-1){
                curr.children[index].eow=true;
            }
            curr=curr.children[index];
        }
    }
    
    public boolean search(String word) {
        return searchUtil(word,root);
    }
    public boolean searchUtil(String word,Node root){
        Node curr=root;

        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            char ch=word.charAt(i);

            if(ch=='.'){
                for(int j=0;j<26;j++){
                    if(curr.children[j]!=null){
                        if(searchUtil(word.substring(i+1),curr.children[j])) return true;
                    }
                }
                return false;
            }
            else {
                if(curr.children[index]==null) return false;
                curr=curr.children[index];
            }
        }
        return curr.eow;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */