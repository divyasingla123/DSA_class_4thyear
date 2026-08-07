class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int currmax=0;
        int maxsum=Integer.MIN_VALUE;
        int currmin=0;
        int minsum=Integer.MAX_VALUE;
        for(int num:nums){
            total+=num;
            currmax=Math.max(num,currmax+num);
            maxsum=Math.max(maxsum,currmax);
            currmin=Math.min(num,currmin+num);
            minsum=Math.min(minsum,currmin);
        }
        if(maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,total-minsum);
    }
}