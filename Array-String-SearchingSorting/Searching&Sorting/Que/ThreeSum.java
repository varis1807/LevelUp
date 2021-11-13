import java.util.*;

public class ThreeSum {
    // three sum / leet 15
    public static List<List<Integer>> allPairs(int[] nums, int tar, int si, int ei) {
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

    public static void makeAns(List<List<Integer>> ans, List<List<Integer>> smallAns, int fix) {
        for (List<Integer> s : smallAns) {
            s.add(fix);
            ans.add(s);
        }
    }

    public static List<List<Integer>> threesum(int[] nums, int si, int ei, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = si; i < ei;) {
            int fix = nums[i];

            // 2 sum
            List<List<Integer>> smallAns = allPairs(nums, target - fix, i + 1, ei);

            makeAns(ans, smallAns, fix);

            i++;
            while (i < ei && nums[i] == nums[i - 1])
                i++;
        }

        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return threesum(nums, 0, nums.length - 1, 0);
    }

}
