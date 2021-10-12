import java.util.*;

public class MinStack {
      // 155
      LinkedList<Long> st = new LinkedList<>();
      long minSf = 0;

      public MinStack() {
      }

      public void push(int val) {
            long x = val;
            if (st.size() == 0) {
                  st.addFirst(x);
                  minSf = x;
                  return;
            }
            if (x < minSf) {
                  st.addFirst(2 * x - minSf);
                  minSf = x;
            } else {
                  st.addFirst(x);
            }
      }

      public void pop() {
            if (st.getFirst() < minSf) {
                  minSf = 2 * minSf - st.getFirst();
            }
            st.removeFirst();
      }

      public int top() {
            if (st.getFirst() < minSf) {
                  return (int) minSf;
            }
            return (int) (long) st.getFirst();
      }

      public int getMin() {
            return (int) minSf;
      }
}
