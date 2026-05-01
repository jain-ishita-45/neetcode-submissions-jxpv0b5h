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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        StringBuilder s=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode cur=q.poll();
            if(cur==null) s.append("#,");
            else
            s.append(cur.val).append(",");
            if(cur!=null)
            {
                q.offer(cur.left);
                q.offer(cur.right);
            }

        }
        return s.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] vals=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(vals[0]));
         Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(!vals[i].equals("#"))
            {node.left=new TreeNode(Integer.parseInt(vals[i]));
            q.offer(node.left);
            }
            i++;
            if(!vals[i].equals("#"))
            {node.right=new TreeNode(Integer.parseInt(vals[i]));
            q.offer(node.right);
            }
            i++;

        }
        return root;
    }
}
