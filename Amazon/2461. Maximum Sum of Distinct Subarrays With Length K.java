class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result=0;
        int i=0,j=0,n=nums.length;
        long currSum=0;
        Set<Integer>mp=new HashSet<>();
        while(j<n) {
            while(mp.contains(nums[j])) {
                currSum-=nums[i];
                mp.remove(nums[i]);
                i++;
            }

            currSum+=nums[j];
            mp.add(nums[j]);

            if(j-i+1==k) {
                result=Math.max(result,currSum);
                currSum-=nums[i];
                mp.remove(nums[i]);
                i++;
            }
            j++;
        }
        return result;
    }
}
