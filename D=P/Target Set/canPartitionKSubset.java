public class canPartitionKSubset {
      //
      public boolean canPartitionKSubsets(int[] nums, int k) {
            int n = nums.length, max = 0;
            long sum = 0;
            for (int el : nums)
                  sum += el;
            int tar = (int) (sum / k);

            if (sum % k != 0)
                  return false;
            return canPartitionKSubsets(nums, k, 0, 0, tar, n, new boolean[n]);
      }
      private boolean canPartitionKSubsets(int[] arr, int k, int idx, int sumSF, int tar, int n, boolean[] vis) {
            if (k == 0)
                  return true;
            if (sumSF > tar)
                  return false;
            if (sumSF == tar || n == 0) {
                  return sumSF == tar ? canPartitionKSubsets(arr, k - 1, 0, 0, tar, n, vis) : false;
            }

            boolean res = false;
            for (int i = idx; i < arr.length; i++) {
                  if (vis[i])
                        continue;
                  vis[i] = true;
                  res = res || canPartitionKSubsets(arr, k, i + 1, sumSF + arr[i], tar, n, vis);
                  vis[i] = false;
            }

            return res;

      }

      public boolean canPartitionKSubsetsAns(int[] nums, int k) {
            return canPartitionKSubsets(nums, k);
      }

}

//public boolean canPartitionKSubsets(int[] nums, int idx, int sum, int target, boolean[] vis, int k) {
      //       if (k == 0)
      //             return true;
      //       if (sum == target)
      //             return canPartitionKSubsets(nums, 0, 0, target, vis, k - 1);

      //       for (int i = idx; i < nums.length; i++) {
      //             if (!vis[i]) {
      //                   vis[i] = true;
      //                   boolean recAns = canPartitionKSubsets(nums, i + 1, sum + nums[i], target, vis, k);
      //                   if (recAns)
      //                         return true;
      //                   vis[i] = false;
      //             }
      //       }
      //       return false;
      // }
      // public boolean canPartition(int[] nums, int k) {
      //       int n = nums.length;
      //       if (k > n)
      //             return false;
      //       if (k == 1)
      //             return true;
      //       int sum = 0;
      //       for (int ele : nums)
      //             sum += ele;
      //       if (sum % k != 0)
      //             return false;

      //       int s = sum / k;

      //       boolean[] vis = new boolean[n + 1];
      //       return canPartitionKSubsets(nums, 0, 0, s, vis, k);
      // }