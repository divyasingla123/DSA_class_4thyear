class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return func(nums,dp,n-1);
    }
    public int func(int nums[],int dp[],int i){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=nums[i]+func(nums,dp,i-2);
        int not=func(nums,dp,i-1);
        dp[i]=Math.max(take,not);
        return dp[i];
    }
}