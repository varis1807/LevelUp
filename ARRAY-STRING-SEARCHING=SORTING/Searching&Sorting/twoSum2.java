import java.util.*;

public class twoSum2 {
      // two sum O(1) space // leet 167
      // ==================================================
      public int[] twoSum_O1(int[] nums, int target) {
            Arrays.sort(nums);

            int si = 0;
            int ei = nums.length - 1;

            while (si < ei) {
                  int csum = nums[si] + nums[ei];

                  if (csum == target) {
                        return new int[] { nums[si], nums[ei] };
                  } else if (csum < target) {
                        si++;
                  } else {
                        ei--;
                  }
            }

            return new int[] {};
      }

      // Solution 1 : BinarySearch
      // Time : O(nlogn)
      // space : O(1)

      public int[] twoSum1(int[] numbers, int target) {
            int n = numbers.length;
            for (int i = 0; i < n - 1; i++) {
                  int pos = Arrays.binarySearch(numbers, i + 1, n, target - numbers[i]);
                  if (pos > 0)
                        return new int[] { i + 1, pos + 1 };
            }
            return null;
      }

      // Solution 2: HashMap
      // Time : O(n)
      // space : O(n)

      public int[] twoSum2(int[] numbers, int target) {
            int n = numbers.length;
            Map<Integer, Integer> seen = new HashMap<>();

            for (int i = 0; i < n; i++)
                  seen.put(numbers[i], i);

            for (int i = 0; i < n - 1; i++)
                  if (seen.containsKey(target - numbers[i]))
                        return new int[] { i + 1, seen.get(target - numbers[i]) + 1 };

            return null;
      }

      // Solution 3 : Two pointers
      // Time : O(n)
      // space : O(1)

      public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length, i = 0, j = n - 1;
            while (i < j) {
                  int sum = numbers[i] + numbers[j];
                  if (sum == target)
                        return new int[] { i + 1, j + 1 };
                  if (sum > target)
                        j--;
                  else
                        i++;
            }
            return null;
      }

}
