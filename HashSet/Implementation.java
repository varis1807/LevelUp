import java.util.HashSet;

public class Implementation {
      public static void impli() {
            HashSet<Integer> set = new HashSet<>();
            set.add(5);
            set.add(10);
            set.add(103);
            set.add(1035);
            set.add(1052);
            set.add(1042);
            System.out.println(set);
            set.size();
            System.out.println(set);
            if(set.contains(10))
            System.out.println("its present");
            else
            System.out.println("its not present");
            set.remove(103);
            System.out.println(set);
            System.out.println(set.isEmpty());
            System.out.println(set.size());

      }

      public static void main(String[] args) {
            impli();
      }
}