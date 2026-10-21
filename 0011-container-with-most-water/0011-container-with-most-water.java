class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Width is the distance between the two lines
            int width = right - left;
            
            // The water level is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate the area and update maxWater if it's larger
            int currentArea = width * currentHeight;
            maxWater = Math.max(maxWater, currentArea);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}
