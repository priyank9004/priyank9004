class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Place each number in its correct index if possible.
        // A number 'x' belongs at index 'x - 1' (e.g., 1 belongs at index 0).
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] to its correct target index
                int targetIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }
        
        // Step 2: Find the first index where the correct number is missing.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // Step 3: If all spots are filled correctly (1 to n), the missing number is n + 1.
        return n + 1;
    }
}
