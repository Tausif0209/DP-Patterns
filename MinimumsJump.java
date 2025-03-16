
class Solution {
    static int minJumps(int[] arr) {
         if(arr[0]==0) return -1;
         int[] dp=new int[arr.length];
         Arrays.fill(dp,-1);
         int ans= recur(arr,dp,0);
         return ans==Integer.MAX_VALUE?-1:ans;
    }
    static int recur(int[] arr,int[] dp,int i){
        if(i>=arr.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int min=Integer.MAX_VALUE;
        for(int j=arr[i];j>=1;j--) min=Math.min(min,recur(arr,dp,i+j));
        
        
        dp[i]=(min==Integer.MAX_VALUE)?min:min+1;
        return dp[i];
}
