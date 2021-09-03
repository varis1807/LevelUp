public class Convert_A_to_B {
      public static void reqBitToConvertAtoB(int a, int b) {
            int ans1=a^b;
            int count=0;
            if((ans1&(ans1-1))==1)
               count++;
            
            System.out.println(count);
      }
      public static void main(String[] args) {
            int a=22;
            int b=27;
      }}
      //vr