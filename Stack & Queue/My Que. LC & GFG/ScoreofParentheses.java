import java.util.*;

public class ScoreofParentheses {
      public static int scoreOfParentheses(String s) {
            int cur = 0;
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);
                  if (ch == '(') {
                        st.push(cur);
                        cur = 0;
                  } else {
                        cur = st.pop() + Math.max(2 * cur, 1);
                  }
            }
            return cur;
      }

      public static void main(String[] args) {
            System.out.println(scoreOfParentheses("(()(()))"));
      }
}
