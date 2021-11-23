public class maxSumRect {
      int kadane_neg(int[] arr){
            int csum=0;
            int msum=-(int)(1e9);
    
            for(int i=0; i<arr.length; i++){
                csum+=arr[i];
    
                msum=Math.max(msum,csum);
    
                if(csum<0){
                    csum=0;
                }
            }
    
            return msum;
        }
    
        int maximumSumRectangle(int R, int C, int M[][]) {
            int ans=-(int)(1e9);
            for(int fixed_row=0; fixed_row<R; fixed_row++){
                int[] pre=new int[C];
    
                for(int row=fixed_row; row<R; row++){
                    for(int col=0; col<C; col++){
                        pre[col]=pre[col]+M[row][col];
                    }
    
                    int sum=kadane_neg(pre);
                    ans=Math.max(ans,sum);
                }
            }
    
            return ans;
        }
}
