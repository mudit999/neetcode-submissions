class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // logic
        // 1. Create a hashmap <String, List of String>
        // 2. Sort every string item in iteration
        // 2.1 Now make key the sorted version and put in map and List of String
        // 2.2 If key matches and add it in list
        // 2.3 If does'nt then create new key and add in map and then add it in list
        // 3. At the end return a list of list of values 


        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] newCArr = str.toCharArray();
            Arrays.sort(newCArr);
            String sortedStr = new String(newCArr);

            if(map.containsKey(sortedStr)){
                // existing entry
                map.get(sortedStr).add(str);
            }else{
                //new entry
                map.put(sortedStr, new ArrayList<String>());
                map.get(sortedStr).add(str);
            }
        }

        List<List<String>> resultant = new ArrayList<>();
        Set<String> keySet = map.keySet();
        
        for(String str : keySet){
            resultant.add(map.get(str));
        }

        return resultant;
    }
}
