import java.util.*;

public class nextGreaterRight {
      // O(n^2)
      public static void printNGE(int[] arr, int n) {
            int i, j;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);

            for (i = 0; i < n; i++) {
                  for (j = i + 1; j < n; j++) {
                        if (arr[i] < arr[j]) {
                              ans[i] = arr[j];
                              break;
                        }
                  }
            }
            for (int k = 0; k < ans.length; k++) {
                  System.out.print(ans[k] + " ");
            }

      }

      // O(n)
      public static void printNGE2(int[] arr, int n) {
            LinkedList<Integer> st = new LinkedList<>();
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            for (int i = 0; i < n; i++) {
                  while (st.size() != 0 && arr[st.getFirst()] < arr[i]) {
                        ans[st.removeFirst()] = arr[i];
                  }
                  st.addFirst(i);
            }
            for (int ele : ans)
                  System.out.print(ele + " ");
      }

      public static void main(String[] args) {
            int[] arr = { 11, 13, 21, 3 };
            int n = arr.length;
            printNGE2(arr, n);
      }
}