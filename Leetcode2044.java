import java.util.Arrays;

public class Leetcode2044 {
  public int countMaxOrSubsets(int[] nums) {
        //Non Dp approach T.c :- O(2^n) and S.c:- O(2^n)
        // if(nums.length==1) return 1;
        // List<Integer> subsetor=new ArrayList<>();
        // subsetor.add(0);
        // int i,j;
        // int maxor=0;
        // int count=0;
        // for(int el:nums)
        // {
        //     maxor|=el;
        // }
        // for(i=0;i<nums.length;i++)
        // {
        //     int size=subsetor.size();
        //     for(j=0;j<size;j++)
        //     {
        //        int val=subsetor.get(j);
        //        int or= val|nums[i];
        //        if(or==maxor) count++;
        //         subsetor.add(or);
        //     }
        // }
        // return count;
        //Dp approach T.C:- O(n*MaxOr) s.c:-O(n*MaxOr)
        int maxOr=maxOr(nums);
        int[][] dp=new int[nums.length][maxOr+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return helper(0,0,nums,dp,maxOr);
    }
    private int helper(int i,int j,int[] nums,int[][] dp,int maxOr){
        if(j>maxOr) return 0;
        if(i==nums.length) return (j==maxOr)?1:0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=helper(i+1,j|nums[i],nums,dp,maxOr)+helper(i+1,j,nums,dp,maxOr);
        return dp[i][j];
    }
    private int maxOr(int[] nums){
        int or=0;
        for(int el:nums) or|=el;
        return or;
    }
}
