/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<Integer> st = new HashSet<>();
        for(int [] a : descriptions){
            int v = a[1];
            st.add(v);
        }
        int rootVal = 0;
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        for(int [] a : descriptions){
            int u = a[0];
            int v = a[1];
            int isLeft = a[2];
            if(isLeft == 1){
                left.put(u,v);
            } else {
                right.put(u,v);
            }
            if(!st.contains(u)) {
                rootVal = u;
                
            }
            if(!st.contains(v)){
                rootVal = v;
                
            }
        }
        TreeNode root = new TreeNode(rootVal);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int val = node.val;
            if(left.containsKey(val)){
                int leftVal = left.get(val);
                TreeNode leftNode = new TreeNode(leftVal);
                node.left = leftNode;
                q.add(leftNode);
            }
            if(right.containsKey(val)){
                int rightVal = right.get(val);
                TreeNode rightNode = new TreeNode(rightVal);
                node.right = rightNode;
                q.add(rightNode);
            }
        }
        return root;
    }
}