import java.util.*;

public class makeGreatSTR {
      public static String makeGood(String s) {
            Stack<Character> st = new Stack();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                  if ((!st.isEmpty()) && ((Math.abs(st.peek() - s.charAt(i))) == 32)) {
                        st.pop();
                  } else {
                        st.add(s.charAt(i));
                  }
            }

            while (st.size() > 0) {
                  sb.append(st.pop());
            }

            return sb.reverse().toString();
      }
      public static void main(String[] args) {
            System.out.println(makeGood("LeEeeTtCoDe"));
      }
}