import java.util.Arrays;

public class Leetcode3202 {
  public int maximumLength(int[] nums, int k) {
        int maxSub=1;
        int[][] dp=new int[k][nums.length];
        for(int[] a:dp)  Arrays.fill(a,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int mod=(nums[i]+nums[j])%k;
                dp[mod][i]=dp[mod][j]+1;
                maxSub=Math.max(maxSub,dp[mod][i]);
            }
        } return maxSub;
    }
}
