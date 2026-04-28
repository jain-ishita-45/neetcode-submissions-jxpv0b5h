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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            
            for(int i=1;i<=level;i++)
            {
                TreeNode nn=q.poll();
                if(nn.left!=null)
                q.offer(nn.left);
                if(nn.right!=null)
                q.offer(nn.right);
                list.add(nn.val);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}
