/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String>res=new ArrayList<>();
        dfsSer(root,res);
      return  String.join(",",res);

    }
    public void dfsSer(TreeNode root,List<String>res){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSer(root.left,res);
        dfsSer(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val=data.split(",");
        int[] i={0};
       return dfsdes(val,i);
    }

    public TreeNode dfsdes(String[] val,int[] i){
        if(val[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(val[i[0]]));
        i[0]++;
        node.left=dfsdes(val,i);
        node.right=dfsdes(val,i);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));