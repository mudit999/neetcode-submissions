// TC: O(n)
// SC: O(1)

class Solution {
    public int maxArea(int[] heights) {
        // Logic: Two pointer
        // 1. Create a left=0 and right=n-1 pointer, maxWaterAmount
        // 2. Now, cal the waterAmount for formed area
        // 2.1 And update the maxWaterAmount
        // 2.2 Now, whose height is smaller out of left and right, move that in there direction

        int n = heights.length;
        int left = 0;
        int right = n-1;
        int maxWaterAmount = 0;

        while(left < right){
            int waterAmount = (right-left) * Math.min(heights[left], heights[right]);
            maxWaterAmount = Math.max(maxWaterAmount, waterAmount);

            if(heights[left] <= heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxWaterAmount;
    }
}
