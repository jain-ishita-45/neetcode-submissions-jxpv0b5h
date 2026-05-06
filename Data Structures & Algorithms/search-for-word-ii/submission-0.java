class TrieNode
{
    TrieNode[] links=new TrieNode[26];
    int idx=-1;
    int refs=0;

    public void addword(String word, int i)
    {
        TrieNode cur=this;
        cur.refs++;
        for(char c:word.toCharArray())
        {
            int index=c-'a';
            if(cur.links[index]==null)
            cur.links[index]=new TrieNode();
            cur=cur.links[index];
            cur.refs++;

        }
        cur.idx=i;
    }
}

class Solution {
    List<String> res=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(int i=0;i<words.length;i++)
        root.addword(words[i],i);
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[0].length;c++)
            {
                dfs(board,root,r,c,words);
            }
        }
        return res;
    }

    public void dfs(char[][] board,TrieNode node, int r, int c, String []words)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]=='*' || node.links[board[r][c]-'a']==null)
        return;

        char temp=board[r][c];
        board[r][c]='*';
        TrieNode prev=node;
        node=node.links[temp-'a'];
        if(node.idx!=-1)
        {
            res.add(words[node.idx]);
            node.idx=-1;
            node.refs--;
            if(node.refs==0)
            {
                node=null;
                prev.links[temp-'a']=null;
                board[r][c]=temp;
                return;
            }
        }
        dfs(board,node,r+1,c,words);
        dfs(board,node,r-1,c,words);
        dfs(board,node,r,c+1,words);
        dfs(board,node,r,c-1,words);
        board[r][c]=temp;


    }
}
