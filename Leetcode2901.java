import java.util.ArrayList;
import java.util.List;

public class Leetcode2901 {
   public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        ArrayList<String> ans=new ArrayList<>();
        int n=words.length;
        if(n==1) {
            ans.add(words[0]);
            return ans;
        }
        ArrayList<String>[] dp=new ArrayList[n];
        for(int i=0;i<n;i++) {
           if(dp[i]==null) dp[i]=helper(i,dp,n,words,groups);
           ans=(dp[i].size()>ans.size())?dp[i]:ans;
        } return ans;

    }
    private ArrayList<String> helper(int i,ArrayList<String>[] dp,int n,String[] words, int[] groups){
        if(dp[i]!=null) return dp[i];
        ArrayList<String> ans=new ArrayList<>();
        int len=words[i].length();
        for(int j=i+1;j<n;j++)
        {
            if((groups[i]!=groups[j]) && (len==words[j].length()) && (hammingDistanceOne(words[i],words[j]))){
                ArrayList<String> list=helper(j,dp,n,words,groups);
                ans=(list.size()>ans.size())?new ArrayList<>(list):ans;
            } 
        } ans.add(0,words[i]);
        dp[i]=ans;
        return dp[i];
    }
    private boolean hammingDistanceOne(String word1,String word2){
        int  len=word1.length();
        int c=0;
        for(int i=0;i<len;i++) {
            if(word1.charAt(i)!=word2.charAt(i)) c++;
            if(c==2) return false;
        } return true;
    }
  
}
