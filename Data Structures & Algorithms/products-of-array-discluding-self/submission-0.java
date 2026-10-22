// TC: O(n)
// SC: O(1)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Logic: 
        // 1. Count no of zeros, cal allProduct
        // 1.1 if zeroCount == 0,
        // traverse the loop and allProduct/num[i]
        // 1.2 Else if zeroCount == 1, 
        // then only that position contains result of non zero elements, rest will be 0
        // 1.3 else zeroCount = 2 or more, all res item will 0
        // do nothing

        int allProduct = 1;
        int zeroCount = 0;

        for(int num : nums){
            allProduct *= num;
            if(num == 0){
                zeroCount += 1;
            }
        }

        System.out.println(zeroCount);
        int[] resultant = new int[nums.length];

        if(zeroCount == 0){
            for(int i=0; i<=nums.length-1; i++){
                resultant[i] = allProduct/nums[i];
            }
        }else if(zeroCount == 1){
            int zeroIndex = 0;
            allProduct = 1;
            for(int i=0; i<=nums.length-1; i++){
                if(nums[i] != 0){
                    allProduct *= nums[i];
                }else{
                    zeroIndex = i;
                }
            }
            resultant[zeroIndex] = allProduct;
        }
        // else if zeroCount >= 2 -> resultant ->[0,0,0,0,0]

        return resultant;
    }
}  
