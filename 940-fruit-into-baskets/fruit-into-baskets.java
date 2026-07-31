class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int k=2;
        int i=0,j=0;
        int max=Integer.MIN_VALUE;
        int count=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        while(j<n){
        if(!mp.containsKey(fruits[j])){
            mp.put(fruits[j],1);
        }
        else{
            mp.put(fruits[j],mp.get(fruits[j])+1);
        }
            while(mp.size()>k){
                if(mp.containsKey(fruits[i])){
                    mp.put(fruits[i],mp.get(fruits[i])-1);
                    if(mp.get(fruits[i])==0){
                        mp.remove(fruits[i]);
                    }
                }
                i++;
            }
            if(mp.size()<=k){
                max=Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
    }
}