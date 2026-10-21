class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Logic:
        // 1. build a freq map
        // 2. Convert map's key into a list
        // 3. Sort the list acc to freq in descending order
        // 4. Get top k elements

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        // build a freq map
        for(int i=0; i<=n-1; i++){
            int currNum = nums[i];
            map.putIfAbsent(currNum, 0);
            int currFreq = map.get(currNum);
            map.put(currNum, currFreq+1);
        }

        Set<Integer> keySet = map.keySet();
        
        // convert map key into a list
        for(Integer num : keySet){
            list.add(num);
        }

        // descending order
        list.sort((a,b) -> map.get(b) - map.get(a));

        int[] result = new int[k];

        // get top k elements
        for(int i=0; i<k; i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
