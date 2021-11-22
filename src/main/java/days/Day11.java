package days;

public class Day11 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode ptr=head.next==null ? null :head.next;
        ListNode last = head;
        if (val==head.val) return head.next;
        if (ptr != null && ptr.val==val){
            head.next = head.next.next;
            return head;
        }
        while (ptr!=null){
            if (ptr.val==val){
                last.next = ptr.next;
                break;
            }else {
                last = ptr;
                ptr = ptr.next;
            }
        }
        return head;
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        //第一轮，获取链表长度；
        ListNode ptr = head;
        int len = 0;
        while (ptr!=null){
            len++;
            ptr = ptr.next;
        }
        ptr = head;
        for (int i = 1; i < len-k-1; i++) {
            ptr = ptr.next;
        }
        return ptr;
    }
}
