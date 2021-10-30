import java.util.*;

public class SearchRotateARR2 {
      // leet 81 ================
      public boolean search(int[] nums, int target) {
            int si = 0;
            int ei = nums.length - 1;
            while (si <= ei) {
                  int mid = (si + ei) / 2;

                  if (nums[mid] == target || nums[si] == target)
                        return true;

                  if (nums[si] < nums[mid]) {
                        if (nums[si] <= target && target < nums[mid]) {
                              ei = mid - 1;
                        } else {
                              si = mid + 1;
                        }
                  } else if (nums[mid] < nums[ei]) {
                        if (nums[mid] < target && target <= nums[ei]) {
                              si = mid + 1;
                        } else {
                              ei = mid - 1;
                        }
                  } else {
                        si++;
                  }
            }

            return false;
      }
}
