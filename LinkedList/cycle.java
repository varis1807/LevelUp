public class cycle {
      public int getCycleLen(ListNode mp) {
            int cycleLen = 1;
            ListNode curr = mp.next;
    
            while (curr != mp) {
                curr = curr.next;
                cycleLen++;
            }
    
            return cycleLen;
        }
    
        public ListNode cycleVariable(ListNode head) {
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
            ListNode mp = fast; // meetingPoint
            int cycleCount = 0;
            int A = 0;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
    
                if (mp == fast)
                    cycleCount++;
                A++;
            }
    
            int cycleLen = getCycleLen(mp);
            int m = 0, C = 0, B = 0;
            if (A != 0 && A % cycleLen == 0) {
                m = cycleCount - 1;
                B = cycleLen;
            } else {
                m = cycleCount + 1;
                C = A - cycleCount * cycleLen;
                B = cycleLen - C;
            }
    
            return slow;
        }
    
}
