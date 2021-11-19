public class subArrKdiffInte {
      public int subarraysWithAtMostKDistinct(int[] nums, int k) {
            int n=nums.length,si=0,ei=0,count=0,ans=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            while(ei<n){
                if(map.containsKey(nums[ei])==false)
                    count++;
                map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
                ei++;
                
                while(count>k){
                    if(map.get(nums[si])==1) count--;
                    map.put(nums[si],map.get(nums[si])-1);
                    if(map.get(nums[si])==0)
                        map.remove(nums[si]);
                    si++;
                }
                ans+=(ei-si);
            }
            return ans;
        }
        public int subarraysWithKDistinct(int[] nums, int k) {
            return subarraysWithAtMostKDistinct(nums,k)-subarraysWithAtMostKDistinct(nums,k-1);
        }
}
