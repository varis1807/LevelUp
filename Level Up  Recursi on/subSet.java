import java.util.*;

public class subSet {
      public void helper(int[] nums, List<List<Integer>> ans, List<Integer> small, int idx) {

            if (idx == nums.length) {
                  ans.add(new ArrayList<>(small));
                  return;
            }
            small.add(nums[idx]);
            helper(nums, ans, small, idx + 1);
            small.remove(small.size() - 1);
            helper(nums, ans, small, idx + 1);

      }

      public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> small = new ArrayList<>();
            helper(nums, ans, small, 0);
            return ans;
      }
}
