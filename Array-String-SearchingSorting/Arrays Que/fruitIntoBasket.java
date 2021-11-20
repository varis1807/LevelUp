public class fruitIntoBasket {
      public int totalFruit(int[] fruits) {
            int n=fruits.length;
            int si=0, ei=0, count=0, ans=0;
            int[] freq=new int[(int)100001];
            while(ei<n){
                if(freq[fruits[ei]]==0) count++;
                freq[fruits[ei]]++;ei++;
                while(count>2){
                    if(freq[fruits[si]]==1)
                        count--;
                    
                    freq[fruits[si]]--;
                    si++;
                }
                ans=Math.max(ans,ei-si);
            }
            return ans;
        }
}
