class Pair{
    String s;
     int l;
    Pair(String s, int l)
    {
        this.s=s;
        this.l=l;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        set.add(wordList.get(i));
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        int minlen=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            Pair node=q.poll();
            String s=node.s;
            int l=node.l;
           
            char s1[]=s.toCharArray();
            for(int i=0;i<s.length();i++)
            {
                char o=s1[i];
                for(char ch='a';ch<='z';ch++)
                {
                    s1[i]=ch;
                    String news=new String(s1);
                    if(news.equals(endWord))
                    {
                        return l+1;
                    }
                    if(set.contains(news))
                    {
                        set.remove(news);
                        q.offer(new Pair(news,l+1));
                    }
                    
                }
                s1[i]=o;
            }

        }
        return 0;
    }
}
