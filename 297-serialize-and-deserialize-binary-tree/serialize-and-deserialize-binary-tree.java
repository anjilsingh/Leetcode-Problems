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
        dfsSerialize(res,root);
        return String.join(",",res);
    }

    public void dfsSerialize(List<String>res,TreeNode root){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSerialize(res,root.left);
        dfsSerialize(res,root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val=data.split(",");
        int[] i={0};
         return des(val,i);

    }

    public TreeNode des(String val[], int[] i){
        if(val[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(val[i[0]]));
        i[0]++;
        root.left=des(val,i);
        root.right=des(val,i);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));