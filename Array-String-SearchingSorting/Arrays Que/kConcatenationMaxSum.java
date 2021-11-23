public class kConcatenationMaxSum {
      public int kadanes(int[] arr, int k){
            int mod=(int)(1e9+7);
    
            long csum=0;
            long msum=0;
            int i=0;
    
            while(k>0){
                while(i<arr.length){
                    csum+=arr[i];
    
                    if(csum<0){
                        csum=0;
                    }
    
                    msum=Math.max(csum,msum);
                    i++;
                }
                i=0;
                k--;
            }
    
            return (int)(msum%mod);
        }
    
        public int kConcatenationMaxSum(int[] arr, int k) {
            int ans_for_2=0;
            long mod=(int)(1e9+7);
    
            long arr_sum=0;
            for(int e:arr){
                arr_sum+=e;
            }
    
            for(int i=1; i<=2; i++){
                int sum=kadanes(arr,i);
    
                if(k==i){
                    return sum;
                }
    
                if(i==2){
                    ans_for_2=sum;
                }
            }
    
            if(arr_sum<0){
                return (int)(ans_for_2 % mod);
            }
    
            int ans=(int)(ans_for_2 + ((k-2)*(arr_sum)%mod));
    
            return Math.max(ans,0);
        }  
}
