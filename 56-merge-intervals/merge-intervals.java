class Solution {
    public int[][] merge(int[][] intervals) {
       if(intervals.length<=1)return intervals;
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
       List<int[]> ans=new ArrayList<>();
       int newinterval[]=intervals[0];
       for(int i=1;i<intervals.length;i++){
        int[] interval = intervals[i];
        if(interval[0]<=newinterval[1]){
            newinterval[1]=Math.max(interval[1],newinterval[1]);
        }
        else{
            ans.add(newinterval);
            newinterval=interval;
        }
       }
       ans.add(newinterval);
       return ans.toArray(new int[ans.size()][]);
    }
}