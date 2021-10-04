import java.util.*;

public class NxtGreater1 {
      public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            for (int i = 0; i < n; i++) {
                  int j = 0;
                  while (j < m) {
                        if (nums1[i] == nums2[j]) {
                              int k = j + 1;
                              while (k < m) {
                                    if (nums2[j] < nums2[k]) {
                                          ans[i] = nums2[k];
                                          break;
                                    }
                                    k++;
                              }
                        }
                        j++;
                  }
            }
            return ans;
      }

      // O(n^2)
      public int[] nextGreaterElement1(int[] findNums, int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
            Stack<Integer> stack = new Stack<>();
            for (int num : nums) {
                  while (!stack.isEmpty() && stack.peek() < num)
                        map.put(stack.pop(), num);
                  stack.push(num);
            }
            for (int i = 0; i < findNums.length; i++)
                  findNums[i] = map.getOrDefault(findNums[i], -1);
            return findNums;
      }
}
