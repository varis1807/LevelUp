public class SingleNumber2 {
      // 137
      public int singleNumber(int[] nums) {
            int k = 3;
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                  int mask = (1 << i);
                  int count = 0;
                  for (int ele : nums) {
                        if ((ele & mask) != 0)
                              count++;
                  }

                  ans |= (count % k) != 0 ? mask : 0;
            }

            return ans;
      }

}
