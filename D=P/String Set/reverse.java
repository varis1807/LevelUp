public class reverse {
      public static String reverseString(String str){  
            //char ch[]=str.toCharArray();  
            String rev="";  
            for(int i=str.length()-1;i>=0;i--){  
                rev+=i;  
            }  
            return rev;  
        }  

      public static void main(String[] args) {
            String s = "abcd";
           System.out.println(reverseString(s));
      }
}
