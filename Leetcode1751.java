import java.util.Arrays;

public class Leetcode1751 {
  public int maxValue(int[][] events, int k) {
        int[][] dp=new int[events.length][k];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return helper(0,0,k,events,dp);
    }
    private int helper(int i,int j,int k,int[][] events,int[][] dp){
        if(j==k || i==events.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=Math.max(events[i][2]+helper(findNext(events,events[i][1]),j+1,k,events,dp) ,helper(i+1,j,k,events,dp));
        return dp[i][j];
    }
    private int findNext(int[][] events,int endDay){
        int start=0,end=events.length;
        while(start<end){
            int mid= start -(start-end)/2;
            if(events[mid][0]>endDay) end=mid;
            else start=mid+1;
        } return start;
    }
}
