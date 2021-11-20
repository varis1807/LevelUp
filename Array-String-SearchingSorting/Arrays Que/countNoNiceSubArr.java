public class countNoNiceSubArr {
      public static int numberOfSubarraysAtMostK(int[] nums, int k) {
            int n=nums.length;
            int si=0, ei=0;
           // int[] fre=new int[50001];
            int count=0;
            int ans=0;
            while(ei<n){
                if(nums[ei]%2 !=0)
                    count++;
                ei++;
                while(count>k){
                    if(nums[si]%2!=0)
                        count--;
                    si++;
                }
                ans+=(ei-si);
            }
            return ans;
        }
        public static int numberOfSubarrays(int[] nums, int k) {
          return numberOfSubarraysAtMostK(nums,k)-numberOfSubarraysAtMostK(nums,k-1);
        }
}
