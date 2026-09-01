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
    public int height(TreeNode root){
        if(root==null||(root.left==null&&root.right==null))return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void traversal(TreeNode root,int i,List<Integer> arr){
        if(root==null)return;
        if(i==1){
            arr.add(root.val);
            return;
        }
        traversal(root.left,i-1,arr);
        traversal(root.right,i-1,arr);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level=height(root)+1;
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return new ArrayList<>();
        for(int i=1;i<=level;i++){
            List<Integer> arr=new ArrayList<>();
            traversal(root,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}