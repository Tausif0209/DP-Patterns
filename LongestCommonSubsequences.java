import java.util.Arrays;
class Solution {
    static int lcs(String s1, String s2) {
          int len1=s1.length();
          int len2=s2.length();
          int[][] dp=new int[len1][len2];
          for(int[] arr:dp) Arrays.fill(arr,-1);
          return findLcs(0,0,s1,s2,dp);
    }
    static int findLcs(int i,int j,String s1,String s2,int[][] dp){
        if(i==dp.length || j==dp[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) dp[i][j]=1+findLcs(i+1,j+1,s1,s2,dp);
        else dp[i][j]=Math.max(findLcs(i+1,j,s1,s2,dp),findLcs(i,j+1,s1,s2,dp));
        return dp[i][j];
    }
}
