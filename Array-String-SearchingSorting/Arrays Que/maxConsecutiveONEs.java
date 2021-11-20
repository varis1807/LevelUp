public class maxConsecutiveONEs {

      // O(n^2)
      public int findMaxConsecutiveOnes(int[] nums) {
            int n = nums.length;
            int count = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                  if (nums[i] == 1) {
                        count++;
                        res = Math.max(res, count);
                  } else
                        count = 0;
            }
            return res;
      }

      // O(nlog(n))
      public int findMaxConsecutiveOnes1(int[] nums) {
            int si = 0, ei = 0, n = nums.length;
            int count = 0; // count 0's
            int ans = 0;
            while (ei < n) {
                  if (nums[ei] == 0)
                        count++;
                  ei++;
                  while (count > 0) {
                        if (nums[si] == 0)
                              count--;
                        si++;
                  }
                  ans = Math.max(ans, ei - si);
            }
            return ans;
      }
}
