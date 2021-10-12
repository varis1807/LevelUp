import java.util.*;

public class NextGreaterNodeLL {
      public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                  this.val = val;
            }

            ListNode(int val, ListNode next) {
                  this.val = val;
                  this.next = next;
            }
      }

      public static class pair {
            int idx;
            ListNode curr;

            pair(int idx, ListNode curr) {
                  this.idx = idx;
                  this.curr = curr;

            }
      }

      public static int[] nextLargerNodes(ListNode head) {
            int count = 0;
            ListNode size = head;
            while (size != null) {
                  size = size.next;
                  count++;
            }
            int[] ans = new int[count];
            ListNode curr1 = head;
            LinkedList<pair> st = new LinkedList<>();
            int idx1 = 0;
            while (curr1 != null) {
                  while (st.size() != 0 && st.getFirst().curr.val < curr1.val) {
                        ans[st.getFirst().idx] = curr1.val;
                        st.removeFirst();
                  }
                  st.addFirst(new pair(idx1, curr1));
                  curr1 = curr1.next;
                  idx1++;
            }
            return ans;
      }

      public static void main(String[] args) {

      }
}
