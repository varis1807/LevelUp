public class LargestNumberPossibleAfterAtMostKSwap {
      // public static String max = "";

      // public static void findMaximum(String str, int k, int ii) {
      // if (k == 0)
      // return;

      // for (int i = ii; i < str.length(); i++) {
      // int idx = -1;
      // char maxCh = '0';
      // for (int j = i + 1; j < str.length(); j++) {
      // if (str.charAt(i) < str.charAt(j) && maxCh < str.charAt(j)) {
      // idx = j;
      // maxCh = str.charAt(j);
      // }
      // }

      // if (idx != -1) {
      // for (int j = idx; j < str.length(); j++) {
      // if (str.charAt(j) == maxCh) {
      // String temp = swap(str, i, j);
      // if (isGreater(temp, max))
      // max = temp;
      // findMaximum(temp, k - 1, i + 1);
      // }
      // }
      // }
      // }
      // }

      // public static boolean isGreater(String temp, String str) {
      // if (temp.length() > str.length())
      // return true;
      // else if (temp.length() < str.length())
      // return false;

      // for (int i = 0; i < str.length(); i++) {
      // if (temp.charAt(i) > str.charAt(i))
      // return true;
      // else if (temp.charAt(i) < str.charAt(i))
      // return false;
      // }

      // return true;
      // }

      // public static String swap(String str, int i, int j) {
      // StringBuilder sb = new StringBuilder(str);
      // char c1 = str.charAt(i);
      // char c2 = str.charAt(j);

      // sb.setCharAt(i, c2);
      // sb.setCharAt(j, c1);

      // return sb.toString();
      // }

      // 2nd methode
      static String max;
      public static String swap(String str, int i, int j) {
            char ith = str.charAt(i);
            char jth = str.charAt(j);
            String left = str.substring(0, i);
            String middle = str.substring(i + 1, j);
            String right = str.substring(j + 1);
            return left + jth + middle + ith + right;

      }
      // Function to find the largest number after k swaps.
      public static void find(String str, int k) {
            if (Integer.parseInt(str) > Integer.parseInt(max))
                  max = str;
            if (k == 0)
                  return;
            for (int i = 0; i < str.length() - 1; i++) {
                  for (int j = i + 1; j < str.length(); j++) {
                        if (str.charAt(j) > str.charAt(i)) {
                              String swapped = swap(str, i, j);
                              find(swapped, k - 1);
                        }
                  }
            }
      }
      public static void findMaximum(String str, int k) {
            find(str, k);

      }
      public static void main(String[] args) {
            // findMaximum("9156911730", 2, 0);
            System.out.println(max);
      }
}
