import java.util.*;

public class segregate0s1sand2s {
      public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
      }

      public static void sortColors(int[] nums) {
            int p1 = -1;
            int p2 = 0;
            int n = nums.length;
            int p3 = n - 1;

            while (p2 <= p3) {
                  if (nums[p2] == 0) {
                        swap(nums, ++p1, p2++);
                  } else if (nums[p2] == 2) {
                        swap(nums, p3--, p2);
                  } else {
                        p2++;
                  }
            }
      }
}
