// TC: O(n)
// SC: O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Logic: Prefix, Suffix product
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // prefix
        for(int i=0; i<=n-1; i++){
            if(i==0){
                prefix[i] = 1;
            }else{
                prefix[i] = nums[i-1] * prefix[i-1];
            }
        }

        // suffix
        for(int i=n-1; i>=0; i--){
            if(i==n-1){
                suffix[i] = 1;
            }else{
                suffix[i] = nums[i+1] * suffix[i+1];
            }
        }

        // result
        int[] resultant = new int[n];
        for(int i=0; i<=n-1; i++){
            resultant[i] = suffix[i] * prefix[i];
        }

        return resultant;
    }
}  
