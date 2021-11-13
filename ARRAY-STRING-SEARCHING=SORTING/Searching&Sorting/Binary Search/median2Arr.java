public class median2Arr {
      public static double findMedianSortedArrays(int[] A, int[] B) {
            int i = 0, j = 0, k = 0;
            int n = A.length, m = B.length, len = n + m;
            int[] ans = new int[len];
            while (i < n && j < m) {
                  if (A[i] < B[j])
                        ans[k++] = A[i++];
                  else
                        ans[k++] = B[j++];
            }
            while (j < m) {
                  ans[k++] = B[j++];
            }
            while (i < n) {
                  ans[k++] = A[i++];
            }
            int finalLen = n + m;
            if (finalLen % 2 == 0) {
                  int sum = (ans[finalLen / 2] + ans[(finalLen - 1) / 2]);
                  return sum * 1.0 / 2.0;
            } else
                  System.out.print(finalLen / 2);
            return ans[finalLen / 2];
      }
}