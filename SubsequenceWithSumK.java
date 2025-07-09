import java.util.Arrays;

public class SubsequenceWithSumK {
   public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
       int[][] dp=new int[arr.length][K+1];
       for(int[] a:dp) Arrays.fill(a,-1);
       return helper(arr,0,K,dp);
    }
    private static boolean helper(int[]arr,int i,int k,int[][] dp){
        if(i==arr.length || k<0) return false;
        if(dp[i][k]!=-1) return dp[i][k]==1;
        if(arr[i]==k){
             dp[i][k]=1;
             return true;
        }
        boolean result=helper(arr,i+1,k-arr[i],dp) || helper(arr,i+1,k,dp);
        dp[i][k] = result ? 1:0;
        return result;
    }
}
