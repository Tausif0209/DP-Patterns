import java.util.Arrays;

public class Leetcode2787 {
  public int numberOfWays(int n, int x) {
        int mod=1_000_000_007;
        long[][] dp=new long[n+1][n+1];
        for(long[] a:dp) Arrays.fill(a,-1);
        return (int)solve(1,n,x,dp,n,mod);
    }
    private long solve(int i,int j,int x,long[][] dp,int n,int mod){
        if(j==0) return 1;
        if(j<0 || (i==n+1)) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int remaining=j-(int)(Math.pow(i,x));
        dp[i][j]=(solve(i+1,remaining,x,dp,n,mod)+solve(i+1,j,x,dp,n,mod))%mod;
        return dp[i][j];
    }
}
