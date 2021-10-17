import java.util.*;

public class KSmall_Largest {
      // O(nLOGn)
      public static int kthSmallest1(Integer[] arr, int k) {
            Arrays.sort(arr);
            return arr[k - 1];
      }

      // O(nLOGk)
      public static int kthSmallest2(int[] arr, int l, int r, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                  return b - a;
            });
            while (l <= r) {
                  pq.add(arr[l]);
                  if (pq.size() > k)
                        pq.remove();
                  l++;
            }
            return pq.peek();
      }
}