public class findDiff {
      public static char find(String s, String t) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                  result ^= s.charAt(i);
                  result ^= t.charAt(i);
            }
            return (char) (result ^ t.charAt(t.length() - 1));
      }

      public static char findTheDifference(String s, String t) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                  // char - char the result is int
                  result += t.charAt(i) - s.charAt(i);
            }
            // use ASCII table to get the letter
            return (char) (result + t.charAt(t.length() - 1));
      }

      public static void main(String[] args) {

      }
}
