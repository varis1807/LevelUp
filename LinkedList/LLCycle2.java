public class LLCycle2 {
      // 142
    public ListNode detectCycle(ListNode head) {
      if (head == null || head.next == null)
          return null;

      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow)
              break;
      }

      if (slow != fast)
          return null;

      slow = head;
      while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
      }

      return slow;
  } 
}
