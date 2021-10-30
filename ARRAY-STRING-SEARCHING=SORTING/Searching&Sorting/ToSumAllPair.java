import java.util.*;
public class ToSumAllPair {
      public List<List<Integer>> allPairs(int[] nums, int tar, int si, int ei) {
            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);

            // int si=0;
            // int ei=nums.length-1;

            while (si < ei) {
                  int csum = nums[si] + nums[ei];

                  if (csum == tar) {
                        ans.add(Arrays.asList(nums[si], nums[ei]));

                        si++;
                        ei--;
                        // 3 options
                        while (si < ei && nums[si] == nums[si - 1])
                              si++;
                        while (si < ei && nums[ei] == nums[ei + 1])
                              ei--;
                  } else if (csum < tar) {
                        si++;
                  } else {
                        ei--;
                  }
            }

            return ans;
      }
}
