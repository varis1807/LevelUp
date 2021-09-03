import java.util.*;
public class TwoSum {
      public static void twoSum(int[] nums, int target,int idx,ArrayList<String> ans,String n) {
            if(target==0){
              ans.add(n);
              return;
            }
            
            for(int i=idx; i<nums.length; i++){
                
                if(target-nums[i]>=0)
                  twoSum(nums,target-nums[i],i+1,ans,n+i);  
            }
            
        }
        public static ArrayList<String> twoSum(int[] nums, int target) {
            ArrayList<String> ans=new ArrayList<>();
            twoSum(nums,target,0,ans,"");
            return ans;
        } 
        public static void main(String[] args) {
              int[] nums={2,7,11,15};
              System.out.println(twoSum(nums, 9));
        }
}
