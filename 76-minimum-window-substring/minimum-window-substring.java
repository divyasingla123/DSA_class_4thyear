class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int k=0;k<t.length();k++){
            char ch=t.charAt(k);
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }
            else{
                mp.put(ch,mp.get(ch)+1);
            }
        }
        int count=mp.size();
        int idx=0;
        while(j<n){
            char ch=s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0)count--;
            }
            while(count==0){
                if(j-i+1<min){
                    min=j-i+1;
                    idx=i;
                }
                char left=s.charAt(i);
                if(mp.containsKey(left)){
                    mp.put(left,mp.get(left)+1);
                    if(mp.get(left)>0)count++;
                }
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE?"":s.substring(idx,min+idx);
    }
}