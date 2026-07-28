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

    long mod = (int)(1e9)+7;

    HashMap<TreeNode,Long> mp;

    long dfs(TreeNode node){
        if(node == null) return 0;
        long sm = (dfs(node.left)+dfs(node.right)+node.val);
        mp.put(node,sm);
        return sm;
    }

    long mx = 0;
    long total;

    void dfs2(TreeNode node){
        if(node == null) return;
        long sz1 = mp.get(node);
        long sz2 = total-sz1;
        long v = (1L*sz1*sz2);
        mx = Math.max(mx,v);
        dfs2(node.left);
        dfs2(node.right);
    }

    public int maxProduct(TreeNode root) {
        mp = new HashMap<>();
        dfs(root);
        total = mp.get(root);
        dfs2(root);
        return (int)(mx%mod);
    }
}