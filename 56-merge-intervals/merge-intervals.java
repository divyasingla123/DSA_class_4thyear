class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n<=1)return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        int newint[]=intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=newint[1]){
                newint[1]=Math.max(newint[1],intervals[i][1]);
            }
            else{
            ans.add(newint);
            newint=intervals[i];
        }
       }
       ans.add(newint);
       return ans.toArray(new int[ans.size()][]);
    }
}