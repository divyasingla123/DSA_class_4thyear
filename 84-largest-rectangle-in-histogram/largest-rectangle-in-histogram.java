class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max=Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:heights[i];
            while(!st.isEmpty()&&heights[st.peek()]>curr){
                int h=heights[st.pop()];
                int right=i;
                int left=(st.isEmpty())?0:st.peek()+1;
                int w=right-left;
                int area=w*h;
                max=Math.max(max,area);
            }
            st.push(i);
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}