import java.util.*;
public class asteroidCollision {
       // 735
    public int[] asteroidCollision(int[] arr) {
      int n = arr.length;
      LinkedList<Integer> st = new LinkedList<>();

      for (int ele : arr) {
          if (ele > 0) {
              st.addFirst(ele);
              continue;
          }

          while (st.size() != 0 && st.getFirst() > 0 && st.getFirst() < -ele)
              st.removeFirst();

          if (st.size() != 0 && st.getFirst() == -ele)
              st.removeFirst();
          else if (st.size() == 0 || st.getFirst() < 0)
              st.addFirst(ele);
          else {
              // nothing to do
          }
      }

      int[] ans = new int[st.size()];
      int idx = ans.length - 1;
      while (st.size() != 0) {
          ans[idx--] = st.removeFirst();
      }

      return ans;
  }

}
