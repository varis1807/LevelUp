import java.util.*;

public class InsertDelGetRand {
      HashMap<Integer, Integer> list = null;
      int[] array = null;
      int index = 0;
      Random random = null;

      /** Initialize your data structure here. */
      public InsertDelGetRand() {
            list = new HashMap<Integer, Integer>();
            array = new int[100001];
            random = new Random();
      }

      /**
       * Inserts a value to the set. Returns true if the set did not already contain
       * the specified element.
       */
      public boolean insert(int val) {
            if (list.containsKey(val)) {
                  return false;
            } else {
                  array[index] = val;
                  list.put(val, index);
                  index++;
                  return true;
            }
      }

      /**
       * Removes a value from the set. Returns true if the set contained the specified
       * element.
       */
      public boolean remove(int val) {
            if (!list.containsKey(val)) {
                  return false;
            } else {
                  int pos = list.remove(val);
                  array[pos] = array[index - 1];
                  if (list.containsKey(array[index - 1])) {
                        list.put(array[index - 1], pos);
                  }
                  index--;
                  return true;
            }
      }

      /** Get a random element from the set. */
      public int getRandom() {
            return array[random.nextInt(index)];
      }









































































































































































































      
      // 380
      // class RandomizedSet
      // {
      // public:
      // unordered_map<int, int> map;
      // vector<int> list;
      // RandomizedSet()
      // {
      // }
      // bool insert(int val)
      // {
      // if (map.find(val) != map.end())
      // return false;
      // int idx = list.size();
      // map[val] = idx;
      // list.push_back(val);
      // return true;
      // }

      // bool remove(int val)
      // {
      // if (map.find(val) == map.end())
      // return false;

      // int idx = map[val];
      // int lidx = list.size() - 1;
      // list[idx] = list[lidx];

      // list.pop_back();
      // map[list[idx]] = idx;
      // map.erase(val);

      // return true;
      // }

      // int getRandom()
      // {
      // int idx = rand() % list.size();
      // return list[idx];
      // }
}