class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String arr[]=path.split("/");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("")||arr[i].equals("."))continue;
            else if(arr[i].equals("..")){
                if(!st.isEmpty())st.pop();
            }
            else{
                st.push(arr[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String var:st){
            sb.append("/").append(var);
        }
        return sb.length()==0?"/":sb.toString();
    }
}