import java.util.*;
public class maxInConfiguration {
      public static int max_sum(int A[], int N) {
            // Your code here
            int totalSum = 0, n = A.length;
            for (int e : A)
                  totalSum += e;
            int cSum = 0;
            for (int i = 0; i < n; i++) {
                  cSum += A[i] * i;
            }
            int max = cSum;
            for (int i = 1; i < n; i++) {
                  int nSum = cSum - (totalSum) + n * A[i - 1];
                  cSum = nSum;
                  max = Math.max(cSum, max);
            }
            return max;
      }
}