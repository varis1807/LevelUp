import java.util.*;

public class DistinctElement {
      // tc=O(n^2);
      public static int find(int[] arr) {
            int res = 1;
            int n = arr.length;
            // Pick all elements one by one
            for (int i = 1; i < n; i++) {
                  int j = 0;
                  for (j = 0; j < i; j++)
                        if (arr[i] == arr[j])
                              break;

                  // If not printed earlier,
                  // then print it
                  if (i == j)
                        res++;
            }
            return res;
      }
      //tc=> O(n);
      public static int find2(int[] arr) {
            HashSet<Integer> set = new HashSet<>();
            for (int ele : arr) {
                  set.add(ele);
            }
            return set.size();
      }

      public static void main(String[] args) {
            int[] arr = { 5, 10, 4, 5, 5, 5, 5, 5 };
            System.out.println(find(arr));
            System.out.print(find2(arr));
      }
}
