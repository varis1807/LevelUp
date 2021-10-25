import java.util.*;
public class ReduceArrHalf {
      public int minSetSize(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>(); // arr[i] vs freq
            for (int i = 0; i < arr.length; i++) {
                  map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int key : map.keySet()) {
                  pq.add(map.get(key));
            }
            int size = arr.length;
            int count = 0;
            while (size > arr.length / 2) {
                  size -= pq.remove();
                  count++;
            }
            return count;
      }
}
