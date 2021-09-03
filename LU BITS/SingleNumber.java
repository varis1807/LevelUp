public class SingleNumber {
      // 136
      public int singleNumber(int[] nums) {

            int ans = 0;
            for (int ele : nums)
                  ans ^= ele;
            return ans;

      }
}
