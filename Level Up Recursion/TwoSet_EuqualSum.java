public class TwoSet_EuqualSum {
      // 2 set of equal sum with string
      public static int equalSet(int[] arr, int idx, int sum1, String set1, int sum2, String set2) {
            if (idx == arr.length) {
                  if (sum1 == sum2) {
                        System.out.println(set1 + " = " + set2);
                        return 1;
                  }
                  return 0;
            }

            int count = 0;
            count += equalSet(arr, idx + 1, sum1 + arr[idx], set1 + arr[idx] + " ", sum2, set2);
            count += equalSet(arr, idx + 1, sum1, set1, sum2 + arr[idx], set2 + arr[idx] + " ");

            return count;
      }

      public static void main(String[] args) {
             int[] arr={10,20,30};
            // System.out.println(equalSet(arr, 0, 0, "", 0, ""));
            System.out.println(equalSet(arr, 1, 10, "10 ", 0, ""));
      }
}
