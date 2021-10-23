import java.util.*;

public class MedianFinder {
      // 295
      private PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> {
            return b - a;
      });
      private PriorityQueue<Integer> minpq = new PriorityQueue<>();

      public MedianFinder() {

      }

      public void addNum(int num) {
            if (maxpq.size() == 0 || num <= maxpq.peek())
                  maxpq.add(num);
            else
                  minpq.add(num);

            if (maxpq.size() - minpq.size() == 2)
                  minpq.add(maxpq.remove());
            if (maxpq.size() - minpq.size() == -1)
                  maxpq.add(minpq.remove());
      }

      public double findMedian() {
            if (maxpq.size() == minpq.size())
                  return (maxpq.peek() + minpq.peek()) / 2.0;
            else
                  return maxpq.peek() * 1.0;
      }
}
