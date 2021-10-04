import java.util.*;

public class StockSpanner {
      // 901

      public static int day = 0;
      public static LinkedList<int[]> st = new LinkedList<>();

      public StockSpanner() {
            // {idx, val}
            st.addFirst(new int[] { -1, -1 });
      }

      public static int next(int price) {
            while (st.getFirst()[0] != -1 && st.getFirst()[1] <= price)
                  st.removeFirst();

            int span = day - st.getFirst()[0];
            st.addFirst(new int[] { day++, price });
            return span;
      }

      public static void main(String[] args) {

      }
}
