public class CopyLLWithRandPointer {
      public static void copyList(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                ListNode forw = curr.next;
                ListNode node = new ListNode(curr.val);
    
                curr.next = node;
                node.next = forw;
    
                curr = forw;
            }
        }
    
        public static void copyRandoms(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
    
                curr = curr.next.next;
            }
        }
    
        public static ListNode extractList(ListNode head) {
            ListNode curr = head, dummy = new ListNode(-1), prev = dummy;
            while (curr != null) {
                ListNode forw = curr.next.next; // backup
    
                prev.next = curr.next; // links
                curr.next = forw;
    
                curr = forw; // move
                prev = prev.next;
            }
    
            return dummy.next;
        }
    
        public static ListNode copyRandomList(ListNode head) {
            copyList(head);
            copyRandoms(head);
            return extractList(head);
        }
    
}
