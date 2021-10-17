public class countingBits {
      // Example 1:
      // Input: n = 2
      // Output: [0,1,1]
      // Explanation:
      // 0 --> 0
      // 1 --> 1
      // 2 --> 10

      // Example 2:
      // Input: n = 5
      // Output: [0,1,1,2,1,2]
      // Explanation:
      // 0 --> 0
      // 1 --> 1
      // 2 --> 10
      // 3 --> 11
      // 4 --> 100
      // 5 --> 101
      public static int[] countBits(int n) {
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                  arr[i] = arr[i & (i - 1)] + 1;
            }
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(i + "->" + arr[i]);
                  System.out.println();
            }
            return arr;
      }

      public static void main(String[] args) {
            System.out.println(countBits(5));
      }
}
