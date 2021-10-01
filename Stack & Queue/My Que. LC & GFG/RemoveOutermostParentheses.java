public class RemoveOutermostParentheses {
      // 1021
      public static String removeOuterParentheses(String s) {
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);
                  if (ch == '(') {
                        if (counter != 0)
                              sb.append(ch);
                        counter++;
                  } else {
                        counter--;
                        if (counter != 0)
                              sb.append(ch);
                  }
            }
            return sb.toString();
      }

      public static void main(String[] args) {
            System.out.println(removeOuterParentheses("(())())"));
      }
}
