public class binarySubArrSum {
      public int atMostnumSubarraysWithSum(int[] nums, int goal) {
            int si = 0, ei = 0, count = 0, n = nums.length, sum = 0, ans = 0;
            while (ei < n) {
                  sum += nums[ei];
                  ei++;
                  while (sum > goal) {
                        sum -= nums[si];
                        si++;
                  }
                  ans += ei - si;
            }
            return ans;
      }

      public int numSubarraysWithSum(int[] nums, int goal) {
            return atMostnumSubarraysWithSum(nums, goal) - (goal == 0 ? 0 : atMostnumSubarraysWithSum(nums, goal - 1));
      }

}
