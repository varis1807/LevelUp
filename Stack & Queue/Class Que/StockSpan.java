import java.util.*;
import java.util.*;

public class StockSpan {

      // Brute Force
      public static int[] calculateSpan(int price[], int n) {
            int[] ans = new int[n];
            int days = 0;
            for (int i = 0; i < n; i++) {
                  days = 0;
                  for (int j = i; j >= 0; j--) {
                        if (price[i] >= price[j]) {
                              days++;
                        } else {
                              break;
                        }
                  }
                  ans[i] = days;
            }
            return ans;
      }

      // https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
      public static int[] calculateSpan1(int[] arr, int n) {
            int[] ans = new int[n];
            LinkedList<Integer> st = new LinkedList<>();
            st.addFirst(-1);

            for (int i = 0; i < n; i++) {
                  while (st.getFirst() != -1 && arr[st.getFirst()] <= arr[i])
                        st.removeFirst();

                  ans[i] = i - st.getFirst();
                  st.addFirst(i);
            }

            return ans;
      }
}
