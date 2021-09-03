public class MisingNumber {
      // 268
      public int missingNumber(int[] nums) {
            int ans = 0;
            int i = 0;
            for (int ele : nums) {
                  ans ^= ele;
                  ans ^= i;
                  i++;
            }

            return ans ^ i;
      }

      public int missingNumber1(int[] nums) {
            int ans = 0, n = nums.length;
            for (int ele : nums) {
                  ans += ele;
            }

            return ((n * (n + 1)) / 2) - ans;
      }

}
