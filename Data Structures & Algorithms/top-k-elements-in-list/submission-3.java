// TC : O(n)
// SC : O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[n+1];

        // initialize inner list
        for(int i=0; i<=freq.length-1; i++){
            freq[i] = new ArrayList<>();
        }

        // build a freq map
        for(int i=0; i<=n-1; i++){
            int currNum = nums[i];
            map.put(currNum, map.getOrDefault(currNum,0)+1);
        }

        // every index contain list of that freq
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        // now get k freq ele
        int index = 0;
        int[] result = new int[k];

        for(int i=freq.length-1; i>0; i--){
            if(freq[i].size() > 0 && index < k){
                for(int key : freq[i]){
                    result[index] = key;
                    index++;
                    if(index == k){
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
