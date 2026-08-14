class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&temperatures[i]>temperatures[st.peek()]){
                int val=st.pop();
                ans[val]=i-val;
            }
            st.push(i);
        }
        return ans;
    }
}