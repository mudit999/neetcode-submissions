class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Logic - Approach 2
        // 1. Create a hashmap <String, List of String>
        // 2. Create a freq array of every String while iterating
        // 2.1 Now convert freq array into a String and put in map as key
        // 2.2 If key matches and add it in list
        // 2.3 If doesn't then create new key and add in map and then add it in list
        // 3. At the end return a list of list of values 


        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] freqStrArr = new int[26];
            for(char ch : str.toCharArray()){
                freqStrArr[ch-'a']++;
            }
            String newKey = 
            Arrays.toString(freqStrArr);
            map.putIfAbsent(newKey, new ArrayList<>());
            map.get(newKey).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
