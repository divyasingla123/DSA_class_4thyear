class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp=new HashMap<>();
        for(String str:strs){
            char arr[]=str.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
            }
            mp.get(key).add(str);
        }
        return new ArrayList<>(mp.values());
    }
}