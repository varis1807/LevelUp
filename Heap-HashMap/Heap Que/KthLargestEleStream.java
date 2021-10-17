import java.util.*;
public class KthLargestEleStream {
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      int K;
      public KthLargestEleStream(int k, int[] nums) {
          K=k;
          for(int ele:nums){
              pq.add(ele);
              if(pq.size()>k)
                  pq.remove();
          }
      }
      
      public int add(int val) {
          pq.add(val);
          if(pq.size()>K)
              pq.remove();
          return pq.peek();
      }
}
