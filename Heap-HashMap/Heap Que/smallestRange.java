import java.util.*;

public class smallestRange {
      // 632
      public static int[] smallRange(List<List<Integer>> nums) {

            int n = nums.size();

            // {r,c} // {ele, r,c};
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>>
                                                                      // pq;
                  int r1 = a[0], c1 = a[1];
                  int r2 = b[0], c2 = b[1];

                  return nums.get(r1).get(c1) - nums.get(r2).get(c2);

            });

            int maxValue = -(int) 1e9;

            for (int i = 0; i < n; i++) {
                  pq.add(new int[] { i, 0 });
                  maxValue = Math.max(maxValue, nums.get(i).get(0));
            }

            int range = (int) 1e9, sp = -1, ep = -1;
            while (pq.size() == n) {

                  int[] re = pq.remove();
                  int r = re[0], c = re[1], val = nums.get(r).get(c);

                  if (maxValue - val < range) {
                        range = maxValue - val;
                        sp = val;
                        ep = maxValue;
                  }

                  c++;
                  if (c < nums.get(r).size()) {
                        pq.add(new int[] { r, c });
                        maxValue = Math.max(maxValue, nums.get(r).get(c));
                  }
            }

            return new int[] { sp, ep };
      }

}
