import java.util.*;
public class noOfSubMat_sum_tar {
     //lc 1074
     public int subarrayCountWithSumEqualTarget(int[] arr, int tar){
      HashMap<Integer,Integer> map=new HashMap<>();

      int csum=0;
      int count=0;
map.put(0,1);
      for(int i=0; i<arr.length; i++){
          csum+=arr[i];

          if(map.containsKey(csum-tar)){
              count+=map.get(csum-tar);
          }
          map.put(csum,map.getOrDefault(csum,0)+1);
      }

      return count;
  }

  public int numSubmatrixSumTarget(int[][] matrix, int target) {
      int R=matrix.length;
      int C=matrix[0].length;

      int ans=0;

      for(int fixed_row=0; fixed_row<R; fixed_row++){
          int[] pre=new int[C];

          for(int row=fixed_row; row<R; row++){
              for(int col=0; col<C; col++){
                  pre[col]=pre[col]+matrix[row][col];
              }

              ans+=subarrayCountWithSumEqualTarget(pre,target);
          }
      }   

      return ans;
  } 
}
