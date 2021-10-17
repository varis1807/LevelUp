import java.util.*;
public class KmostFrequentEle {
      // CPP
      // // 347
      // vector<int>
      // topKFrequent(vector<int> &nums, int k){
      // unordered_map<int, int> map;
      // for (int ele : nums)
      // map[ele]++;
      // //{freq,ele}
      // priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
      // for (pair<int, int> p : map){
      // pq.push({p.second, p.first});
      // if (pq.size() > k)
      // pq.pop();
      // }
      // vector<int> ans;
      // while (pq.size() != 0){
      // vector<int> key = pq.top();
      // pq.pop();
      // ans.push_back(key[1]);
      // }
      // return ans;
      // }
      public static int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int ele : nums)
                  map.put(ele, map.getOrDefault(ele, 0) + 1);
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            for (int ele : map.keySet()) {
                  pq.add(ele);
                  if (pq.size() > k)
                        pq.remove();
            }
            int idx = 0;
            int[] ans = new int[k];
            while (pq.size() != 0) {
                  int key = pq.peek();
                  pq.remove();
                  ans[idx] = key;
                  idx++;
            }
            for(int i=0; i<ans.length; i++){
                  System.out.print(ans[i]+"");
            }
            return ans;
      }

      public static void main(String[] args) {
            int[] arr = { 1, 1, 1, 2, 2, 3 };
            System.out.println(topKFrequent(arr, 2));
            
      }
}
