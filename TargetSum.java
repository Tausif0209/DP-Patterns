import java.util.Arrays;

public class TargetSum {
  public int findTargetSumWays(int[] nums, int target) {
        int[][] dp=new int[nums.length][2001];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return countWays(nums,0,target,dp);
    }
    private int countWays(int[] nums,int i,int target,int[][] dp){
        if(i==nums.length) return (target==0)?1:0;
        if (target < -1000 || target > 1000) return 0;
        if(dp[i][target+1000]!=-1) return dp[i][target+1000];
        dp[i][target+1000]=countWays(nums,i+1,target-nums[i],dp) + countWays(nums,i+1,target+nums[i],dp);
        return dp[i][target+1000];
    }
}
