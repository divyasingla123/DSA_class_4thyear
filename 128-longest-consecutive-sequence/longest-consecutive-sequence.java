class Solution {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            st.add(arr[i]);
        }
        int curr=-1;
        int len=-1;
        int maxlen=0;
        for(int i:st){
            if(!st.contains(i-1)){
                curr=i;
                len=1;
                while(st.contains(curr+1)){
                    curr++;
                    len++;
                }
            }
            maxlen=Math.max(maxlen,len);
        }
        return maxlen;
    }
}