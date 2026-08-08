class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int ans[]=new int[2];
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int sum=nums[i];
            if(mp.containsKey(target-sum)){
                ans[0]=mp.get(target-sum);
                ans[1]=i;
                return ans;
            }
            mp.put(sum,i);
        }
        return ans;
    }
}