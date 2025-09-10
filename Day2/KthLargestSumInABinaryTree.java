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

//leetcode ques no 2583
https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> result = new ArrayList<>();
        if(root == null){
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            Long sum = 0l;
            for(int i =0;i<levelsize;i++){
                TreeNode currentNode = queue.poll();
                sum = sum+currentNode.val;
                 if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(sum);
        }
        Collections.sort(result);
       if (k > result.size()) {
            return -1; // not enough levels
        }
        
        return result.get(result.size() - k); // kth largest
    }
}
