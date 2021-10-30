import java.util.*;

public class ThreeSum {
    // three sum / leet 15

    public void makeAns(List<List<Integer>> ans, List<List<Integer>> smallAns, int fix) {
        for (List<Integer> s : smallAns) {
            s.add(fix);
            ans.add(s);
        }
    }
   public static List<List<Integer>> 3sum(int[] nums, int si, int ei, int target){
      List<List<Integer>> ans = new ArrayList<>();

      for(int i=si; i<ei;){
          int fix=nums[i];
          
          // 2 sum
          List<List<Integer>> smallAns=allPairs(nums,target-fix,i+1,ei);

          makeAns(ans,smallAns,fix);

          i++;
          while(i<ei && nums[i]==nums[i-1]) i++;
      }

      return ans;
  }

 
  public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      return 3sum(nums,0,nums.length-1,0);
  }

    public List<List<Integer>>3sum(int[] nums, int si, int ei, int target){
      List<List<Integer>> ans = new ArrayList<>();

      for(int i=si; i<ei;){
          int fix=nums[i];   
          // 2 sum
          List<List<Integer>> smallAns=3sum(nums,i+1,ei,target-fix);
          makeAns(ans,smallAns,fix);
          i++;
          while(i<ei && nums[i]==nums[i-1]) i++;
      }
      return ans;
  }
}
