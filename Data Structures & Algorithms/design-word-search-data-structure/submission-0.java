class Node
{
    Node links[]=new Node[26];
    boolean flag=false;

    public boolean containsKey(char ch)
    {
        return links[ch-'a']!=null;
    }

    public void put(char ch, Node node)
    {
        links[ch-'a']=node;
    }

    public Node get(char ch)
    {
        return links[ch-'a'];
    }

    public void setEnd()
    {
        flag=true;
    }

    public boolean isEnd()
    {
        return flag;
    }
}

class WordDictionary {
    private static Node root;

    public WordDictionary() {
        root=new Node();

    }

    public void addWord(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
            node.put(word.charAt(i),new Node());
            node=node.get(word.charAt(i));
        }
        node.setEnd();

    }

    public boolean search(String word) {
       return dfs(0,word,root);

    }

    public boolean dfs(int i, String word, Node node)
    {
        Node cur=node;
        for(int j=i;j<word.length();j++)
        {
            char c=word.charAt(j);
            if(c=='.')
            {
                for(Node child:cur.links)
                {
                    if(child!=null && dfs(j+1,word,child))
                    return true;
                }
                return false;
            }
            else
            {
                if(cur.get(c)==null)
                return false;
                cur=cur.get(c);
            }
        }
        return cur.flag;
    }
}
