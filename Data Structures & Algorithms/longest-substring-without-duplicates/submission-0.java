// TC: O(n^2)
// SC: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Logic
        // 0. Maintain a global longestLenRes for max length
        // 1. Traverse the String
        // 1.1 Check all possible substring from ith char
        // 1.2 Keep pushing it in hashset, check the size, update in global longestLenRes
        // NOTE: In next traversal, empty the hashset

        int longestLenRes = 0;
        HashSet set = new HashSet<>();

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
