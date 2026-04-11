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
    boolean isBalancedVar = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalancedVar;
    }

    public int dfs(TreeNode root){
        if(root == null || isBalancedVar == false) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(isBalancedVar && Math.abs(left - right) > 1){
            isBalancedVar = false;
        }
        return 1 + Math.max(left, right);
    }
}
