class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int num:nums){
            sum+=num;
            if(sum==k)count++;
            if(mp.containsKey(sum-k)){
                count+=mp.get(sum-k);
            }
            if(mp.containsKey(sum)){
                mp.put(sum,mp.get(sum)+1);
            } 
            else{
                mp.put(sum,1);
            }
        }
        return count;
    }
}