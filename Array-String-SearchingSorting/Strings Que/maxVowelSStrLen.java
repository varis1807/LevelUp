public class maxVowelSStrLen {

      public static boolean isVowel(char c) {
            return c == 'e' || c == 'a' || c == 'i' || c == 'o' || c == 'u';
      }

      public int maxVowels(String s, int k) {
            int ei = 0, si = 0, vowelCount = 0;
            int[] fre = new int[128];

            while (ei < k) {
                  if (isVowel(s.charAt(ei)))
                        vowelCount++;
                  fre[s.charAt(ei)]++;
                  ei++;
            }
            int ans = vowelCount;
            while (ei < s.length()) {
                  ans = Math.max(ans, vowelCount);

                  // ei++
                  if (isVowel(s.charAt(ei)))
                        vowelCount++;
                  fre[s.charAt(ei)]++;
                  ei++;
                  // si++
                  if (isVowel(s.charAt(si)))
                        vowelCount--;
                  fre[s.charAt(si)]--;
                  si++;
            }
            ans = Math.max(ans, vowelCount);
            return ans;
      }
      // 2nd methode

      public int maxVowels1(String s, int k) {
            int si = 0;
            int ei = 0;
            int vc = 0;
            int[] fre = new int[128];
            int ans = 0;
            while (ei < s.length()) {
                  if (isVowel(s.charAt(ei)))
                        vc++;

                  fre[s.charAt(ei)]++;
                  ei++;

                  if (k == ei - si) {
                        ans = Math.max(ans, vc);
                        if (isVowel(s.charAt(si)))
                              vc--;

                        fre[s.charAt(si)]--;
                        si++;
                  }
            }
            return ans;
      }
}
