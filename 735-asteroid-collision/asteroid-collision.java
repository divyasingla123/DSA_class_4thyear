class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&asteroids[i]<0&&st.peek()>0){
                int sum=asteroids[i]+st.peek();
                if(sum<0){
                    st.pop();
                }
                else if(sum==0){
                    st.pop();
                    asteroids[i]=0;
                }
                else{
                    asteroids[i]=0;
                }
            }
            if(asteroids[i]!=0){
                st.push(asteroids[i]);
            }
        }
        int s=st.size();
        int ans[]=new int[s];
        for(int i=s-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}