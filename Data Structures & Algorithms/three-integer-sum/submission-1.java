// TC: O(n^2)
// SC: O(1)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       // Logic
       // 1. Sort the nums[]
       // 2. Now initialize 3 variables -> a,left, right
       // 3. First loop -> we will select a, handle a duplicates
       // 3.2 Second loop, we will do (2 Sum II) with target -> -a
       // handle left and right duplicates as well

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();

        for(int i=0; i<=n-3; i++){
            int a = i;
            int left = i+1;
            int right = n-1;

            // Skip duplicate first elements
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int target = -1 * nums[a];
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }else{
                    resultList.add(new ArrayList<>(Arrays.asList(nums[a], nums[left], nums[right])) );
                    left++;
                    right--;

                    // now duplicates can appear for left and right as well, skip it
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }

        return resultList;
    }
}
