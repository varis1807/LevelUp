import java.util.*;

//1047
public class RemoveAllAdjacentDupInStr {
      public static String removeDuplicates(String s) {
            LinkedList<Character> st = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);
                  if (st.size() == 0 || ch != st.peek())
                        st.addFirst(ch);

                  else if (st.peek() == ch)
                        st.removeFirst();
            }

            while (st.size() != 0) {
                  char c = st.removeLast();
                  sb.append(c);
            }
            return sb.toString();
      }

      public static void main(String[] args) {
            System.out.println(removeDuplicates("abbaca"));
      }
}
