import java.util.*;

public class MinRemoveMakeValidParen {
      // rajnees Sir approach
      // 1249
      public String minRemoveToMakeValid(String s) {
            int n = s.length();
            LinkedList<Integer> st = new LinkedList<>();
            char[] chArr = s.toCharArray();

            for (int i = 0; i < n; i++) {
                  char ch = s.charAt(i);
                  if (ch == ')') {
                        if (st.size() != 0)
                              st.removeFirst();
                        else
                              chArr[i] = '#';
                  } else if (ch == '(')
                        st.addFirst(i);
            }

            while (st.size() != 0)
                  chArr[st.removeFirst()] = '#';

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                  if (chArr[i] != '#')
                        sb.append(s.charAt(i));

            }

            return sb.toString();
      }

      // My aproach
      public String minRemoveToMakeValid1(String s) {
            Stack<Character> stack = new Stack<>();
            Stack<Integer> index = new Stack<>();

            StringBuilder str = new StringBuilder(s);

            for (int i = 0; i < s.length(); i++) {
                  if (s.charAt(i) == '(') {
                        stack.push(s.charAt(i));
                        index.push(i);
                  } else if (s.charAt(i) == ')') {
                        if (!stack.isEmpty() && stack.peek() == '(') {
                              stack.pop();
                              index.pop();
                        } else {
                              index.push(i);
                        }

                  }

            }

            while (!index.isEmpty()) {
                  str.deleteCharAt(index.pop());
            }
            return str.toString();
      }
}