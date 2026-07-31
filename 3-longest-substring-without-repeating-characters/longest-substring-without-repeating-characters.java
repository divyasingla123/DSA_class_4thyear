class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        int i=0,j=0;
        int min=0;
        while(j<n){
            char ch=s.charAt(j);
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }
            else{
                mp.put(ch,mp.get(ch)+1);
            }
            while(j-i+1>mp.size()){
                char left=s.charAt(i);
                mp.put(left,mp.get(left)-1);
                if(mp.get(left)==0){
                    mp.remove(left);
                }
                i++;
            }
            if(j-i+1==mp.size()){
                min=Math.max(min,j-i+1);
            }
            j++;
        }
        return min;
    }
}