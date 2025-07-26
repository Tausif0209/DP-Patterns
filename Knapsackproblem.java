import java.util.Arrays;

public class Knapsackproblem {
     static int knapsack(int W, int val[], int wt[]) {
        //Top Down approach (recursion + memoization)
        int[][] dp=new int[val.length][W+1];
        for(int[] a:dp)
        Arrays.fill(a,-1);
        return helper(0,W,val,wt,dp);
    }
    private static int helper(int i,int j,int[] val,int[] wt,int[][] dp)
    {
        if(i==val.length || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(j>=wt[i]) dp[i][j]=Math.max(helper(i+1,j-wt[i],val,wt,dp)+val[i],
        helper(i+1,j,val,wt,dp));
        else dp[i][j]=helper(i+1,j,val,wt,dp);
        return dp[i][j];
    }
}
