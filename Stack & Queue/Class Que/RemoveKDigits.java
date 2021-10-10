import java.util.*;
public class RemoveKDigits {
      public static String removeKdigits(String num, int k) {
            ArrayList<Character> st = new ArrayList<>();

            for (int i = 0; i < num.length(); i++) {
                  char ch = num.charAt(i);
                  while (st.size() != 0 && st.get(st.size() - 1) > ch && k > 0) {
                        k--;
                        st.remove(st.size() - 1);
                  }
                  st.add(ch);
            }

            while (k-- > 0)
                  st.remove(st.size() - 1);

            StringBuilder sb = new StringBuilder();
            boolean nonZeroValue = false;
            for (Character ch : st) {
                  if (ch == '0' && !nonZeroValue)
                        continue;

                  nonZeroValue = true;
                  sb.append(ch);
            }

            return sb.length() != 0 ? sb.toString() : "0";
      }
}
