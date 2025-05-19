import java.util.Arrays;

public class Leetcode1931 {
  int index=0;
    public int colorTheGrid(int m, int n) {
        if(m==1 && n==1) return 3;
        int den=(int)(Math.pow(10,9))+7;
        if(n==1) return (int)((3*(long)Math.pow(2,m-1))%den);
        String[] arr=new String[3*(int)Math.pow(2,m-1)];
        helper(new StringBuilder(),m,arr);
        int[][] dp=new int[arr.length][n];
        int ways=0;
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<arr.length;i++){
           ways=(ways+solve(i,1,dp,arr,n,den))%den;
        } return ways;
    }
    void helper(StringBuilder sb,int m,String[] arr){
        int len=sb.length();
        if(len==m){
        arr[index++]=sb.toString();
        return ;
    }
    char[] colors={'R','B','G'};
    for(int i=0;i<3;i++){
        if(len==0 || (sb.charAt(len-1)!=colors[i])) {
        helper(sb.append(colors[i]),m,arr);
        sb.deleteCharAt(len);
    }}}
    private int solve(int i,int j,int[][] dp,String[] colors,int n,int den){
        if(j==n) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int ways=0;
        for(int k=0;k<colors.length;k++){
            if(k==i) continue;
            if(isPossible(colors[i],colors[k])) ways=(ways+solve(k,j+1,dp,colors,n,den))%den;
        } dp[i][j]=ways;
        return dp[i][j];
    }
    boolean isPossible(String s1,String s2){
        boolean flag=true;
        int len=s1.length();
        for(int i=0;i<len;i++) flag=flag && (s1.charAt(i)!=s2.charAt(i));
        return flag;
    }
}
