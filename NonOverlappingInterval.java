import java.util.Arrays;
//using DP 
public class NonOverlappingInterval {
  public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return n-count(dp,0,intervals,n);
    }
    private int count(int[] dp,int i,int[][] intervals,int n){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
       dp[i]=Math.max(count(dp,findNext(intervals[i][1],intervals),intervals,n)+1,count(dp,i+1,intervals,n));
        return dp[i];
    }
    private int findNext(int key,int[][] arr){
        int start=0,end=arr.length;
        while(start<end){
            int mid = start - (start-end)/2;
            if(arr[mid][0]>=key) end=mid;
            else start=mid+1;
        } return start;
    }
}
