import java.util.*;
import java.util.*;
public class StockSpan {
      // https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
    public static int[] calculateSpan(int[] arr, int n) {
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
