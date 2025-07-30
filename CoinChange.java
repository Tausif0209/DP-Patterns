import java.util.Arrays;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] a:dp) Arrays.fill(a,-2);
        return helper(coins,amount,dp,0);
    }
    private int helper(int[] coins,int amount,int[][] dp,int i){
        if(amount==0) return 0;
        if(i==coins.length) return -1;
        if(dp[i][amount]!=-2) return dp[i][amount];
        int min=Integer.MAX_VALUE;
        for(int j=0;1L*j*coins[i]<=amount;j++){
            int remainingCoin=helper(coins,amount-j*coins[i],dp,i+1);
            if(remainingCoin!=-1)  min=Math.min(min,remainingCoin+j);
        }
        dp[i][amount]= min==Integer.MAX_VALUE?-1:min;
        return dp[i][amount];
    }
}
