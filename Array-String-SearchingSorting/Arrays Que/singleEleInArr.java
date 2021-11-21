import java.util.*;
public class singleEleInArr {
      public int singleNonDuplicate(int[] arr) {
            int n = arr.length;
             HashMap<Integer,Integer> map = new HashMap<>();
             for(int ele:  arr)
               map.put(ele,map.getOrDefault(ele,0)+1);
               
             PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                  if (map.get(a) == map.get(b))
                             return b.compareTo(a);
                       return map.get(a) - map.get(b);
             });
           pq.addAll(map.keySet());        
             int count = 0;
             int ans =-1;
             while(pq.size() != 0){
              int key = pq.remove();    
               for(int i=0;i<map.get(key);i++)
                 return  key;
             }
             return -1;
         }
}
