class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int left=0;
        int right=0;
        for(int i=0;i<n;i++){
            left=Math.max(left,weights[i]);
            right+=weights[i];
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            int numofdays=find(weights,mid);
            if(numofdays<=days){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public int find(int weights[],int cap){
        int day=1,load=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+load>cap){
                day++;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return day;
    }
}