class Solution {
    public int minDistance(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }        
        return func(text1,text2,n-1,m-1,dp);
    }
    public int func(String text1, String text2,int i,int j,int dp[][]){
        if(j<0)return i+1;
        if(i<0)return j+1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=func(text1,text2,i-1,j-1,dp);
        }
        else dp[i][j]=1+Math.min(func(text1,text2,i,j-1,dp),Math.min(func(text1,text2,i-1,j,dp),func(text1,text2,i-1,j-1,dp)));
        return dp[i][j];
    }
}