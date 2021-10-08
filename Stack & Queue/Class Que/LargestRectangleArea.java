import java.util.*;

public class LargestRectangleArea {
      public static int[] NSOR(int[] arr) {
            int n = arr.length;
            int[] ans = new int[n];
            Arrays.fill(ans, n);
            LinkedList<Integer> st = new LinkedList<>();
            st.addFirst(-1);

            for (int i = 0; i < n; i++) {
                  while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                        ans[st.removeFirst()] = i;

                  st.addFirst(i);
            }

            return ans;
      }

      public static int[] NSOL(int[] arr) {
            int n = arr.length;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            LinkedList<Integer> st = new LinkedList<>();
            st.addFirst(-1);

            for (int i = n - 1; i >= 0; i--) {
                  while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i])
                        ans[st.removeFirst()] = i;

                  st.addFirst(i);
            }

            return ans;
      }

      // 7n
      public int largestRectangleArea_01(int[] heights) {
            int[] nsol = NSOL(heights); // 3n
            int[] nsor = NSOR(heights); // 3n

            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) { // n
                  maxArea = Math.max(maxArea, heights[i] * (nsor[i] - nsol[i] - 1));
            }

            return maxArea;
      }

      // 84
      // 2n
      public int largestRectangleArea(int[] heights) {
            int n = heights.length, maxArea = 0;
            LinkedList<Integer> st = new LinkedList<>();
            st.addFirst(-1);

            for (int i = 0; i < n; i++) {
                  while (st.getFirst() != -1 && heights[st.getFirst()] >= heights[i]) {
                        int h = heights[st.removeFirst()];
                        int w = i - st.getFirst() - 1;
                        maxArea = Math.max(maxArea, h * w);
                  }
                  st.addFirst(i);
            }

            while (st.getFirst() != -1) {
                  int h = heights[st.removeFirst()];
                  int w = n - st.getFirst() - 1;
                  maxArea = Math.max(maxArea, h * w);
            }

            return maxArea;
      }

}