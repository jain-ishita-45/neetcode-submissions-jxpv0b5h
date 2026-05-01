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
    int prefixidx=0;
    public int search(int [] inorder, int left,int right, int val)
    {
        for(int i=left;i<=right;i++)
        {
            if(val==inorder[i])
            return i;
        }
        return -1;
    }
    public TreeNode helper(int[] preorder, int[] inorder,  int left, int right)
    {
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[prefixidx]);
        int idx=search(inorder,left, right, preorder[prefixidx]);
        prefixidx++;
        root.left=helper(preorder,inorder,left,idx-1);
        root.right=helper(preorder,inorder,idx+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,inorder.length-1);
    }
}
