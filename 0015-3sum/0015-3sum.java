import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to use the two-pointer technique
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // If the smallest number in the triplet is positive, we can't sum to 0
            if (nums[i] > 0) {
                break;
            }
            
            // Skip the duplicate numbers for the outer loop element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                
                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate numbers for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate numbers for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers onward after tracking a valid solution
                    left++;
                    right--;
                } else if (total < 0) {
                    // Sum is too small; move the left pointer to increase it
                    left++;
                } else {
                    // Sum is too large; move the right pointer to decrease it
                    right--;
                }
            }
        }
        return result;
    }
}
