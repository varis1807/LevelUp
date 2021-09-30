public class MaxNestingDepthofParen {
      // 1614
      public static int maxDepth(String s) {
            int max = 0, count = 0;
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);
                  if (ch == '(') {
                        ++count;
                        max = Math.max(count, max);
                  }
                  if (ch == ')')
                        count--;
            }
            return max;
      }

      public static void main(String[] args) {
            System.out.println(maxDepth("()))())()())())((((())))))()(()()())("));
      }
}
