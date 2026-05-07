/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> old=new HashMap<>();
        return dfs(node,old);
        
    }

    public Node dfs(Node node,Map<Node,Node> old)
    {
        if(node==null) return null;
        if(old.containsKey(node))
        return old.get(node);
        Node copy=new Node(node.val);
        old.put(node,copy);
        for(Node nei:node.neighbors)
        copy.neighbors.add(dfs(nei,old));
        return copy;
    }
}