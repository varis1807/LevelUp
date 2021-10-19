import java.util.*;
public class arrIncreasingFreq {
      public static int[] frequencySort(int[] arr) {
            int n = arr.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int ele : arr)
                  map.put(ele, map.getOrDefault(ele, 0) + 1);

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                  if (map.get(a) != map.get(b))
                        return map.get(a) - map.get(b);
                  else
                        return b - a;
            });

            for (Integer ele : map.keySet()) {
                  pq.add(ele);
            }
            int count = 0;
            int[] ans = new int[n];
            while (pq.size() != 0) {
                  int key = pq.remove();
                  for (int i = 0; i < map.get(key); i++)
                        ans[count++] = key;
            }
            return ans;
      }
}
