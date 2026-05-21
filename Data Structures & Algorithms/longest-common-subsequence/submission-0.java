class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp=new int[text1.length()][text2.length()];
        for(int r[]:dp) Arrays.fill(r,-1);
        return check(0,0,text1,text2,dp);
    }

    public int check(int i, int j, String text1, String text2, int [][]dp)
    {
        if(i>=text1.length() || j>=text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int pick=0;
        if(text1.charAt(i)==text2.charAt(j))
        pick=1+check(i+1,j+1,text1,text2,dp);
        int nt=check(i,j+1,text1,text2,dp);
        int t=check(i+1,j,text1,text2,dp);
        return dp[i][j]=Math.max(pick,Math.max(nt,t));

    }
}
