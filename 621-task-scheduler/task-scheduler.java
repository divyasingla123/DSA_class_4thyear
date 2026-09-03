class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch:tasks){
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }
            else{
                mp.put(ch,mp.get(ch)+1);
            }
        }
        int time=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int freq:mp.values()){
           pq.add(freq);
        }
        while(!pq.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
            int work=0;
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int freq=pq.poll();
                    freq--;
                    work++;
                    if(freq>0)temp.add(freq);
                }
            }
            for(int t:temp){
                if(t>0)pq.add(t);
            }
            if(pq.isEmpty()){
                time+=work;
            }
            else{
                time+=n+1;
            }
        }
        return time;
    }
}