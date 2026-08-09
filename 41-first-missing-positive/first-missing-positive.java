class Solution {
    public int firstMissingPositive(int[] nums) {
        int num=1;
        Arrays.sort(nums);
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        while(num<=nums[nums.length-1]){
            if(!st.contains(num))return num;
            num++;
        }
        return num;
    }
}