public class SingleNumber3 {
      // 260
      public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int ele : nums)
                  xor ^= ele;
            int xor_mask = xor & (-xor);

            int A = 0, B = 0;
            for (int ele : nums)
                  if ((ele & xor_mask) == 0)
                        A ^= ele;
                  else
                        B ^= ele;

            return new int[] { A, B };
      }
}
