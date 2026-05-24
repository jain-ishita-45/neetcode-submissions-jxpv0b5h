class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        for(int r[]:dp)
        Arrays.fill(r,-1);
        return check(word1,word2,0,0,dp);
    }

    public int check(String s1, String s2, int i, int j, int [][]dp)
    {
        if(j==s2.length()) return s1.length()-i;
        if(i==s1.length()) return s2.length()-j;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=0;
        if(s1.charAt(i)==s2.charAt(j))
        res=check(s1,s2,i+1,j+1,dp);
        else
        res=Math.min(check(s1,s2,i+1,j+1,dp), Math.min(check(s1,s2,i,j+1,dp),check(s1,s2,i+1,j,dp)))+1;
        return dp[i][j]=res;
    }


}
