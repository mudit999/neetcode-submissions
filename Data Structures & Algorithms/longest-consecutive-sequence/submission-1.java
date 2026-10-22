// TC: O(n)
// SC: O(n)

class Solution {
    public int longestConsecutive(int[] nums) {
        // Logic : HashSet
        // 1. Create a set for O(1) lookup and to remove duplicates
        // 2. Now iterate all num in set
        // 2.1 Check if num-1 exist in set (starting point), now if found, increase the len -> len+1, continue this till you found increased len
        // 2.2 Update the longest


        int longest = 0;
        Set<Integer> store = new HashSet<>();

        for(int num : nums){
            store.add(num);
        }

        for(int num : store){
            if(!store.contains(num-1)){

                int len = 1;
                while(store.contains(num+len)){
                    len += 1;
                }
                longest = Math.max(len, longest);
            }
        }

        return longest;
    }
}
