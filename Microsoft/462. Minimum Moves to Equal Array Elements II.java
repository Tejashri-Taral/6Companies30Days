class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        int median=nums[n/2];
        for(int num:nums) {
            ans+=Math.abs(median-num);
        }
        return ans;
    }
}
