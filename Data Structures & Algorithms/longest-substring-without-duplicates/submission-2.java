// TC: O(n)
// SC: O(m), m - unique chars

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Logic
        // 1. Create a set -> window for unique chars
        // 2. Create a variable l - start of window
        // 2.1 Create a var resLen - store max Len
        // 3. Now iterate the s String from r=0
        // 3.1 If set contains duplicate
        // -> remove char at l, l++ (basically shrinking the window from left till duplicate is remove)
        // 3.2 Push char[r] in set (expand window)
        // 3.3 Cal the size of window, update resLen


        Set<Character> set = new HashSet<>();
        int l = 0;
        int resLen = 0;
        int n = s.length();

        for(int r=0; r<=n-1; r++){
            while(set.contains(s.charAt(r))){
                // shrink
                set.remove(s.charAt(l));
                l++;
            }

            // expand
            set.add(s.charAt(r));
            resLen = Math.max(resLen, set.size());
        }   

        return resLen;    
    }
}
