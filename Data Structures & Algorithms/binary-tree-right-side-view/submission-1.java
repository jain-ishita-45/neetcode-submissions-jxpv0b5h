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
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        while(!q.isEmpty())
        {
            List<Integer> list=new ArrayList<>();
            int level=q.size();
            for(int i=1;i<=level;i++)
            {
                TreeNode nn=q.poll();
                if(nn.left!=null)
                q.offer(nn.left);
                if(nn.right!=null)
                q.offer(nn.right);
                list.add(nn.val);
                
            }
            for(int i:list)
            System.out.print(i+" ");
            if(list.size()>0)
            ans.add(list.get(level-1));
        }
        return ans;
    }
}
