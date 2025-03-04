class Solution {
    static int lis(int arr[]) {
      if(arr.length==1) return 1;
      int max=1;
      int[] dp=new int[arr.length];
      for(int i=0;i<arr.length;i++){
          if(dp[i]==0) max=Math.max(max,findLIS(i,arr,dp));
          else max=Math.max(max,dp[i]);
      }
       return max; 
    }
    static int findLIS(int i,int[] arr,int[] dp){
        if(i==arr.length) return 0;
        if(dp[i]!=0) return dp[i];
        int max=0;
        for(int j=i+1;j<arr.length;j++){
           if(arr[j]>arr[i]) max=Math.max(max,findLIS(j,arr,dp));
        }
        dp[i]=max+1;
        return dp[i];
    }
}