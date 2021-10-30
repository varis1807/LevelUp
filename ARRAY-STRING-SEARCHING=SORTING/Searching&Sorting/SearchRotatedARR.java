import java.util.*;
public class SearchRotatedARR {
        // leet 33 ============================================

    public int search(int[] nums, int target) {
      int si=0;
      int ei=nums.length-1;
      
      while(si<=ei){
          int mid=si+(ei-si)/2;
          
          if(nums[mid]==target) return mid;
          
          if(si==mid || nums[si]<nums[mid]){ // from si to mid, nums is sorted
              if(nums[si]<=target && nums[mid]>target){
                  ei=mid-1;
              } else {
                  si=mid+1;
              }
          } else {
              if(nums[mid]<target && nums[ei]>=target){
                  si=mid+1;
              } else {
                  ei=mid-1;
              }
          }
      }
      
      return -1;
  }
}
