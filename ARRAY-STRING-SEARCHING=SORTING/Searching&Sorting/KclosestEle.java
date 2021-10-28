public class KclosestEle {
      public class Pair implements Comparable<Pair> {
            int val, gap;

            Pair() {
            }

            Pair(int val, int gap) {
                  this.val = val;
                  this.gap = gap;
            }

            public int compareTo(Pair o) {
                  if (this.gap == o.gap)
                        return this.val - o.val;
                  else
                        return this.gap - o.gap;
            }
      }

      public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < arr.length; i++) {
                  if (pq.size() < k)
                        pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
                  else {

                        if (pq.peek().gap > Math.abs(arr[i] - x)) {
                              pq.remove();
                              pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
                        }
                  }
            }
            while (pq.size() > 0) {
                  Pair rem = pq.remove();
                  list.add(rem.val);
            }
            Collections.sort(list);
            return list;
      }
}
