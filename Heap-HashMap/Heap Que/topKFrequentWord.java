import java.util.*;

public class topKFrequentWord {
      public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : words)
                  map.put(s, map.getOrDefault(s, 0) + 1);
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
                  if (map.get(a) == map.get(b))
                        return b.compareTo(a);
                  return map.get(a) - map.get(b);
            });
            for (String s : map.keySet()) {
                  pq.add(s);
                  if (pq.size() > k)
                        pq.remove();
            }
            List<String> ans = new LinkedList<>();
            while (pq.size() != 0) {
                  ans.add(0, pq.remove());
            }
            return ans;
      }
}
