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
            while (pq.size() != 0)
                  System.out.println(pq.remove());
            return pq.peek();
      }

      public static void main(String[] args) {
            int[] arr = { 7, 4, 10, 3, 20, 15 };
            System.out.println(kthSmallest2(arr, 0, 5, 3));
      }
}