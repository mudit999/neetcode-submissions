// TC: O(n)
// SC: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Steps:
        // 1. Traverse the array and find if diff exists in
        // Map
        // 2. If yes -> build result and break
        // 3. else -> put curr ele and index in map
        
        int[] resultantArr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i=0; i<=n-1; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                resultantArr[0] = map.get(diff);
                resultantArr[1] = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }

        return resultantArr;
    }
}
