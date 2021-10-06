import java.util.*;
public class validStackSequ {
        // 946
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      int n = pushed.length, idx = 0;
      LinkedList<Integer> st = new LinkedList<>();
      for (int ele : pushed) {
          st.addFirst(ele);
          while (st.size() != 0 && st.getFirst() == popped[idx]) {
              idx++;
              st.removeFirst();
          }
      }

      return st.size() == 0;
  }
}
