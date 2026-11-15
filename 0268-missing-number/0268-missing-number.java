class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int arrsum=0;
        int n=nums.length;
        sum=(n*(n+1)/2);
        for(int i=0;i<nums.length;i++)
        {
            arrsum+=nums[i];
        }
        return(sum-arrsum);
        
    }
}