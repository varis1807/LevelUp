import java.util.*;

public class furthestBuilding {
      // 1642
      public static int furthestBuild(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int n = heights.length;
            for (int i = 1; i < n; i++) {
                  int currDiff = heights[i] - heights[i - 1];
                  if (currDiff > 0) {
                        pq.add(currDiff);

                        if (pq.size() > ladders) {
                              bricks -= pq.remove();
                        }

                        if (bricks < 0)
                              return i - 1;
                  }
            }

            return n - 1;
      }
}
