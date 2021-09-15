public class ShortestCommonSuperSeq {

      public static String shortestCommonSupersequence(String str1, String str2) {
            int n1 = str1.length();
            int n2 = str2.length();
            int[][] mem = new int[n1 + 1][n2 + 1];

            // Simple Longest Common Subsequence
            for (int i = 1; i <= n1; i++) {
                  for (int j = 1; j <= n2; j++) {
                        char ch1 = str1.charAt(i - 1);
                        char ch2 = str2.charAt(j - 1);
                        if (ch1 == ch2) {
                              mem[i][j] = 1 + mem[i - 1][j - 1];
                        } else {
                              mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
                        }
                  }
            }
            //BackEngineering with logic of SuperSequence
            int i = n1;
            int j = n2;
            StringBuilder str = new StringBuilder();
            while (i > 0 && j > 0) {
                  if (mem[i][j] == mem[i - 1][j]) {
                        str.append(str1.charAt(i - 1));
                        i--;
                  } else if (mem[i][j] == mem[i][j - 1]) {
                        str.append(str2.charAt(j - 1));
                        j--;
                  } else {
                        str.append(str1.charAt(i - 1));
                        i--;
                        j--;
                  }
            }
            while (i-- > 0) {
                  str.append(str1.charAt(i));
            }
            while (j-- > 0) {
                  str.append(str2.charAt(j));
            }
            return str.reverse().toString();
      }

      public static void main(String[] args) {
            System.out.println(shortestCommonSupersequence("abac","cab"));
      }
}
