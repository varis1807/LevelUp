public class UnFold {
      public static ListNode reverse(ListNode head) {
            if (head == null || head.next == null)
                  return head;

            ListNode prev = null, curr = head;
            while (curr != null) {
                  ListNode forw = curr.next; // backup

                  curr.next = prev; // link

                  prev = curr;
                  curr = forw;
            }

            return prev;
      }

      public static void unfold(ListNode head) {
            if (head == null || head.next == null)
                  return;

            ListNode d1 = new ListNode(-1), d2 = new ListNode(-1), c1 = d1, c2 = d2, c = head;

            while (c != null) {
                  c1.next = c;
                  c2.next = c.next;

                  c1 = c1.next;
                  c2 = c2.next;

                  c = c.next;
                  if (c != null)
                        c = c.next;
            }

            c1.next = null;
            ListNode rhead = reverse(d2.next);
            c1.next = rhead;
      }
}
