class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=0;
        int ans[]=new int[n-k+1];
        int idx=0;
        Deque<Integer> dq=new LinkedList<>();
        while(j<n){
            while(!dq.isEmpty()&&dq.peekLast()<nums[j]){
                dq.pollLast();
            }
            dq.offerLast(nums[j]);
            if(j-i+1>k){
                if(dq.peekFirst()==nums[i])dq.pollFirst();
                i++;
            }
            if(j-i+1==k){
                ans[idx++]=dq.peekFirst();
            }
            j++;
        }
        return ans;
    }
}