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
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append("null,");
                continue;
            }
            sb.append(node.val+",");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String [] arr = data.split(",");

        int n = arr.length;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        int i = 1;
        while(!q.isEmpty()){
            
            TreeNode node = q.poll();
            if(!arr[i].equals("null")){
                TreeNode l = new TreeNode(Integer.parseInt(arr[i]));
                node.left = l;
                q.add(l);
            }
            i++;
            if(!arr[i].equals("null")){
                TreeNode r = new TreeNode(Integer.parseInt(arr[i]));
                node.right = r;
                q.add(r);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));