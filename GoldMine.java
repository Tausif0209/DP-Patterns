import java.util.Arrays;

public class GoldMine {
    public int maxGold(int[][] mat) {
        int[][] dp=new int[mat.length][mat[0].length];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int[] dir={-1,0,1};
        int max=0;
        for(int i=0;i<mat.length;i++) max=Math.max(max,helper(mat,dp,i,0,dir));
        return max;
        
    }
    private int helper(int[][] mat,int[][] dp,int i,int j,int[] dir){
        if(i<0 || i==mat.length || j<0 || j==mat[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max=0;
        for(int d:dir) max=Math.max(max,helper(mat,dp,i+d,j+1,dir));
        dp[i][j]=mat[i][j]+max;
        return dp[i][j];
    }
}
