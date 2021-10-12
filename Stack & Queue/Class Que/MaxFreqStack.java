import java.util.*;

public class MaxFreqStack {
      // O(n)
      private class pair implements Comparable<pair> {
            int val = 0;
            int idx = 0;
            int freq = 0;

            pair(int val, int idx, int freq) {
                  this.val = val;
                  this.idx = idx;
                  this.freq = freq;
            }

            public int compareTo(pair o) {
                  if (this.freq == o.freq)
                        return o.idx - this.idx;
                  else
                        return o.freq - this.freq;

            }
      }

      private PriorityQueue<pair> pq;
      private HashMap<Integer, Integer> freq;
      private int idx = 0;

      // public FreqStack() {
      // pq = new PriorityQueue<>();
      // freq = new HashMap<>();
      // }

      public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            pq.add(new pair(val, idx++, freq.get(val)));
      }

      public int pop() {
            pair rp = pq.remove();
            freq.put(rp.val, rp.freq - 1);
            if (freq.get(rp.val) == 0)
                  freq.remove(rp.val);
            return rp.val;
      }

      public int top() {
            pair rp = pq.peek();
            return rp.val;
      }

      // O(1)
      private ArrayList<LinkedList<Integer>> freqMap;
      private HashMap<Integer, Integer> map;
      private int maxFreq = 0;

      // public FreqStack() {
      // freqMap = new ArrayList<>();
      // map = new HashMap<>();

      // freqMap.add(new LinkedList<>());
      // }

      public void push1(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(val));

            if (maxFreq == freqMap.size())
                  freqMap.add(new LinkedList<>());

            freqMap.get(map.get(val)).addFirst(val);
      }

      public int pop1() {
            int rv = freqMap.get(maxFreq).removeFirst();
            if (freqMap.get(maxFreq).size() == 0) {
                  freqMap.remove(maxFreq--);
            }

            map.put(rv, map.get(rv) - 1);
            if (map.get(rv) == 0)
                  map.remove(rv);

            return rv;
      }
}
