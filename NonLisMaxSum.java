public class NonLisMaxSum {
  public int nonLisMaxSum(int[] arr) {
        if(arr.length==1) return 0;
        int[][] dp=new int[arr.length][2];
        int sum=0,count=0,total=0;
        for(int i=0;i<arr.length;i++){
            if(dp[i][0]==0) dp[i]=LIS(arr,dp,i);
            if(dp[i][0]>count){
                count=dp[i][0];
                sum=dp[i][1];
            }
            else if(dp[i][0]==count) sum=Math.min(dp[i][1],sum);
            total+=arr[i];
        } return total-sum;
    }
    private int[] LIS(int[] arr,int[][] dp,int i){
        if(dp[i][0]!=0) return dp[i];
        for(int j=i+1;j<arr.length;j++) {
            if(arr[j]<=arr[i]) continue;
            int[] a=LIS(arr,dp,j);
            if(a[0]>dp[i][0]){
                dp[i][0]=a[0];
                dp[i][1]=a[1];
            }
            else if(a[0]==dp[i][0]) dp[i][1]=Math.min(dp[i][1],a[1]);
        }
        dp[i][0]++;
        dp[i][1]+=arr[i];
        return dp[i];
    }
}
