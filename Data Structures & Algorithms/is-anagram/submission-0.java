// TC: O(n)
// SC: O(n)

class Solution {
    public boolean isAnagram(String s, String t) {
        // Steps:
        // 1. Create an array of 26 length 
        // 2. Traverse all String s, increment the freq of array correct index ((int)ch-97)
        // 3. Now in second traversal of String t, decrement the freq of array
        // 4. Now in third traversal, check if all the array ele freq is zero, if yes -> anagram, else not an anagram

        int[] freqArr = new int[26];
        int sLen = s.length();
        int tLen = t.length();

        for(int i=0; i<=sLen-1; i++){
            int correctIndex = (int)s.charAt(i) - 97;
            freqArr[correctIndex] += 1;
        }

        for(int i=0; i<=tLen-1; i++){
            int correctIndex = (int)t.charAt(i) - 97;
            freqArr[correctIndex] -= 1;
        }

        for(int i=0; i<=25; i++){
            if(freqArr[i] != 0){
                return false;
            }
        }

        return true;
    }
}
