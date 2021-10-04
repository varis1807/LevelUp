import java.util.*;

public class Dailytemp {
      // Brute Force
      // O[n^2]
      public static int[] dailyTemperatures(int[] arr) {
            int n = arr.length;
            int[] ans = new int[n];
            int day = 0;
            Arrays.fill(ans, 0);
            for (int i = 0; i < n; i++) {
                  day = 0;
                  int j = i + 1;
                  while (j < n) {
                        if (arr[i] < arr[j]) {
                              ++day;
                              ans[i] = day;
                              break;
                        } else {
                              day++;
                        }
                        j++;
                  }
            }
            return ans;
      }
      
}
