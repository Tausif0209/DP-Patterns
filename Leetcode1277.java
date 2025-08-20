import java.util.Arrays;

public class Leetcode1277 {
   public int countSquares(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int[] d:dp) Arrays.fill(d,-1);
        int subMatrix=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if(dp[i][j]==-1) dp[i][j]=dfs(dp,i,j,matrix.length,matrix[0].length,matrix);
                subMatrix+=dp[i][j];
            }
        } return subMatrix;
    }
    private int dfs(int[][] dp,int i,int j,int n,int m,int[][] matrix){
        if(i==n || i<0 || j==m || j<0 || matrix[i][j]==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=1+Math.min(dfs(dp,i,j+1,n,m,matrix),Math.min(dfs(dp,i+1,j+1,n,m,matrix),
        dfs(dp,i+1,j,n,m,matrix)));
        return dp[i][j];
    }
}
