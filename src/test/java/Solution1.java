public class Solution1 implements Solution {
    @Override
    public ListNode rotateRight(ListNode head, int k) {

        int len = length(head);

        ListNode newHead = head;
        if (len > 0) {
            for (int i = 0; i < k % len; i++) {
                newHead = rotate(newHead);
            }
        }

        return newHead;
    }

    private ListNode rotate(ListNode head) {
        ListNode first = head, prev = null, p = head;
        while (p != null && p.next != null) {
            prev = p;
            p = prev.next;
        }
        if (prev != null) {
            head = p;
            p.next = first;
            prev.next = null;
        }
        return head;
    }

    private int length(ListNode head) {
        if (head == null) {
            return 0;
        } else {
            return length(head.next)+1;
        }
    }
}
