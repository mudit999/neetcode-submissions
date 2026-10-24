// TC: O(n^2)
// SC: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Logic
        // 1. Maintain a global longestLenRes for max length
        // 2. Traverse the String
        // 2.1 Check all possible substring from ith char
        // 2.2 Create a new HashSet
        // 2.2 Start another loop, keep pushing it in hashset, check the size, update in global longestLenRes
        // 2.3 If duplicate found, break the inner loop

        int longestLenRes = 0;
        Set<Character> set = new HashSet<>();

        for(int i=0; i<=s.length()-1; i++){
            set = new HashSet<>();
            for(int j=i; j<=s.length()-1; j++){
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                }
                longestLenRes = Math.max(longestLenRes, set.size());
            }
        }

        return longestLenRes;
    }
}
