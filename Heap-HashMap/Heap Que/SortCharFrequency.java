import java.util.*;

public class SortCharFrequency {
      public String frequencySort1(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);
                  map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> {
                  return b.getValue() - a.getValue();
            });
            for (Map.Entry<Character, Integer> c : map.entrySet()) {
                  pq.add(c);
            }
            String S = "";
            while (pq.size() != 0) {
                  Map.Entry<Character, Integer> element = pq.remove();
                  for (int i = 0; i < element.getValue(); i++)
                        S += element.getKey();
            }
            return S;
      }

      public static String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray())
                  map.put(c, map.getOrDefault(c, 0) + 1);

            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            
            pq.addAll(map.entrySet());

            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                  Map.Entry e = pq.poll();
                  for (int i = 0; i < (int) e.getValue(); i++)
                        sb.append(e.getKey());
            }
            return sb.toString();
      }
}
