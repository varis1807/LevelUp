import java.util.*;
public class fourSUMcount {
      // leet 454 

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      HashMap<Integer,Integer> map=new HashMap<>();
      
      for(int e:nums1){
          for(int f:nums2){
              map.put(e+f,map.getOrDefault(e+f,0)+1);
          }
      }
      
      int ans=0;
      for(int e:nums3){
          for(int f:nums4){
              if(map.containsKey(0-(e+f))){
                  ans+=map.get(0-(e+f));
              }
          }
      }
      
      return ans;
  }
}
