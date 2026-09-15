class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int width=right-left;
            int h=Math.min(height[left],height[right]);
            int area=width*h;
            max=Math.max(max,area);
            if(height[left]<height[right])left++;
            else right--;
        }
        return max;
    }
}