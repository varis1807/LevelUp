import java.util.*;

public class WordBreak {
      public static Scanner scn = new Scanner(System.in);

      public static void wordBreak(String str, String ans, HashSet<String> dict) {
            if (str.length() == 0)
                  System.out.println(ans);

            for (int ei = 0; ei < str.length(); ei++) {
                  String pWord = str.substring(0, ei + 1);
                  if (dict.contains(pWord)) {
                        wordBreak(str.substring(ei + 1), ans + pWord + " ", dict);
                  }
            }

      }

      public static void main(String[] args) {
            int n = scn.nextInt();
            HashSet<String> dict = new HashSet<>();
            for (int i = 0; i < n; i++) {
                  dict.add(scn.next());
            }
            String sentence = scn.next();
            wordBreak(sentence, " ", dict);
      }
}
