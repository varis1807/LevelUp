public class SegregeteOverAtIdx {
      public static ListNode segregate(ListNode head, int idx) {
            if (head == null || head.next == null)
                  return head;

            int i = 0, data = 0;
            ListNode curr = head;
            while (curr != null) {
                  if (i == idx)
                        data = curr.val;

                  i++;
                  curr = curr.next;
            }

            ListNode smaller = new ListNode(-1);
            ListNode sp = smaller;

            ListNode greater = new ListNode(-1);
            ListNode gp = greater;

            i = 0;
            curr = head;
            ListNode pivot = null;
            while (curr != null) {
                  if (i == idx) {
                        pivot = curr;
                  } else if (curr.val <= data) {
                        sp.next = curr;
                        sp = sp.next;
                  } else {
                        gp.next = curr;
                        gp = gp.next;
                  }

                  curr = curr.next;
                  i++;
            }

            sp.next = pivot;
            pivot.next = greater.next;
            gp.next = null;
            sp = sp.next;

            return smaller.next;
      }

}
