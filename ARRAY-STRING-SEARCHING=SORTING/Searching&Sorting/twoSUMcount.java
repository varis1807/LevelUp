import java.util.*;
public class twoSUMcount {
      // two sum count ====================================
    public int count(int[] arr1, int[] arr2, int target){
      int ans=0;

      HashMap<Integer,Integer> map=new HashMap<>();

      for(int i=0; i<arr1.length; i++){
          map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
      }

      for(int i=0; i<arr2.length; i++){
          int new_target=target-arr2[i];

          if(map.containsKey(new_target)){
              ans+=map.get(new_target);
          }
      }

      return ans;
  }

}
