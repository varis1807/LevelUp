public class ShortestUncommonSubSeq {
      public static int shortUnCommonSS(String str1, String str2, int a, int b) {

            if (a == 0 || b == 0) {
                  return 0;
            }
            int count = 0;
            if (str1.charAt(a - 1) != str2.charAt(b - 1))
                  count = shortUnCommonSS(str1, str2, a - 1, b - 1) + 1;
            else
                  count = Math.max(shortUnCommonSS(str1, str2, a - 1, b), shortUnCommonSS(str1, str2, a, b ));

            return count;
      }

      public static void main(String[] args) {
            String str1 = "babab", str2 = "babba";
            int a = str1.length();
            int b = str2.length();
            System.out.println(shortUnCommonSS(str1, str2, a, b));
      }
}
