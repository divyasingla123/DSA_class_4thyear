class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m)return false;
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> st=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!mp.containsKey(s1.charAt(i))){
                mp.put(s1.charAt(i),1);
            }
            else mp.put(s1.charAt(i),mp.get(s1.charAt(i))+1);
        }
        int i=0,j=0;
        while(j<m){
            char ch=s2.charAt(j);
            if(!st.containsKey(ch)){
                st.put(ch,1);
            }
            else{
                st.put(ch,st.get(ch)+1);
            }
            if(j-i+1>n){
                st.put(s2.charAt(i),st.get(s2.charAt(i))-1);
                if(st.get(s2.charAt(i))==0){
                    st.remove(s2.charAt(i));
                }
                i++;
            }
            if(mp.equals(st))return true;
            j++;
        }
        return false;
    }
}