public class MinWindowSStr {
      //LC 76
      public static String minWindow(String s, String t) {
            int len = (int) 1e9, need = 0;
            int s1 = s.length(), t1 = t.length();
            int gSI = 0;// globalSI
            int si = 0, ei = 0;
            int[] requirements = new int[128];

            for (int i = 0; i < t1; i++) {
                  requirements[t.charAt(i)]++;
                  need++;
            }
            while (ei < s1) {
                  if (requirements[s.charAt(ei)] > 0)
                        need--;
                  requirements[s.charAt(ei)]--;
                  ei++;

                  while (need == 0) {
                        if (len > (ei - si)) {
                              len = ei - si;
                              gSI = si;
                        }
                        if (requirements[s.charAt(si)] == 0)
                              need++;

                        requirements[s.charAt(si)]++;
                        si++;
                  }
            }
            return len == (int) 1e9 ? "" : s.substring(gSI, gSI + len);
      }
      public static void main(String[] args) {
            
      }
}
