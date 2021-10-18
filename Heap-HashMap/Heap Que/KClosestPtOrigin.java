import java.util.*;

public class KClosestPtOrigin {
      public static int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                  int d1 = points[a][0] * points[a][0] + points[a][1] * points[a][1];
                  int d2 = points[b][0] * points[b][0] + points[b][1] * points[b][1];
                  return d2 - d1;
            });
            for (int i = 0; i < points.length; i++) {
                  pq.add(i);
                  if (pq.size() > k)
                        pq.remove();
            }
            int ans[][] = new int[k][];
            int i = 0;
            while (pq.size() != 0) {
                  int idx = pq.remove();
                  ans[i++] = points[idx];
            }
            return ans;
      }
      public static void main(String[] args) {
            
      }
}
