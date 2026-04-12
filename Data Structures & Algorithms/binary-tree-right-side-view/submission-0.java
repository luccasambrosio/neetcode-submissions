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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<Integer> res = new ArrayList<>();

        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                TreeNode currentNode = deque.poll();
                size--;
                if(currentNode.left != null) deque.add(currentNode.left);
                if(currentNode.right != null) deque.add(currentNode.right);
                if(size == 0) res.add(currentNode.val);
            }
            
        }

        return res;
    }
}
