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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r){
        if(l > r) return null;

        TreeNode node = new TreeNode(preorder[preIndex++]);
        node.left = dfs(preorder, inorder, l, map.get(node.val) - 1);
        node.right = dfs(preorder, inorder, map.get(node.val) + 1, r);
        return node;
    }
}
