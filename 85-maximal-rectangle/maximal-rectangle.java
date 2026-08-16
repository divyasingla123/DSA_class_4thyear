class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max_area=Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()] > curr){
                int height=heights[st.pop()];
                int right=i;
                int left=(st.isEmpty())?0:st.peek()+1;
                int width=right-left;
                int area=width*height;
                max_area=Math.max(max_area,area);
            }
            st.push(i);
        }
        return max_area==Integer.MIN_VALUE?0:max_area;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int height[]=new int[m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1')height[j]++;
                else height[j]=0;
            }
            int area=largestRectangleArea(height);
            max=Math.max(max,area);
        }
        return max;
    }
}