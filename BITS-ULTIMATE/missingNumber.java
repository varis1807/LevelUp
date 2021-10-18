public class missingNumber {
      public static int missingNumber(int[] nums) {
            int sum = 0;
            for (int num : nums)
                  sum += num;
            return (nums.length * (nums.length + 1)) / 2 - sum;
      }

      public static int missingNumber1(int[] nums) {
            int xor = 0, i = 0;
            for (i = 0; i < nums.length; i++) {
                  xor = xor ^ i ^ nums[i];
            }
            return xor ^ i;
      }
}
