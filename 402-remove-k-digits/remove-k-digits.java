class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&k>0&&st.peek()-'0'>num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder ans=new StringBuilder();
        for(char ch:st){
            ans.append(ch);
        }
        int i=0;
        while(i<ans.length()&&ans.charAt(i)=='0'){
            i++;
        }
        if(i==ans.length()){
            return "0";
        }
        return ans.substring(i);
    }
}