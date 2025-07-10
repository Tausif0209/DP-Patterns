import java.util.Arrays;

public class PerfectSum {
   public int perfectSum(int[] nums, int target) {
        int[][] dp=new int[nums.length][target+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return count(nums,0,target,dp);
    }
    private int count(int[] nums,int i,int target,int[][] dp){
        if(target<0) return 0;
        if(i==nums.length) return target == 0?1:0;
        if(dp[i][target]!=-1) return dp[i][target];
        dp[i][target]=(count(nums,i+1,target-nums[i],dp) + count(nums,i+1,target,dp));
        return dp[i][target];
    }
}
