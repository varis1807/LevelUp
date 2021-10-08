import java.util.*;
public class LongestValidParenthesis {
        // 32
    public int longestValidParentheses(String s) {
      int n = s.length(), maxLen = 0;
      LinkedList<Integer> st = new LinkedList<>();
      st.addFirst(-1);

      for (int i = 0; i < n; i++) {
          char ch = s.charAt(i);
          if (ch == ')' && st.getFirst() != -1 && s.charAt(st.getFirst()) == '(') {
              st.removeFirst();
              maxLen = Math.max(maxLen, i - st.getFirst());
          } else
              st.addFirst(i);
      }

      return maxLen;
  }
}
