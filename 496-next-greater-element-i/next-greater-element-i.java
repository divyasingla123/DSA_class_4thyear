class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        int res[]=new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<m;i++){
            while(!st.isEmpty()&&st.peek()<nums2[i]){
                mp.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums1[i])){
                res[i]=mp.get(nums1[i]);
            }
        }
        return res;
    }
}