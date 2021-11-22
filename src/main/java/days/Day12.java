package days;

public class Day12 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //合并两个排序链表，归并排序
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;
        ListNode head = null,ptr = null;
        if (l1_ptr.val < l2_ptr.val){
            head = l1_ptr;
            l1_ptr = l1_ptr.next;//l1指针向后移动
            ptr = head;
        }else {
            head = l2_ptr;
            l2_ptr = l2_ptr.next;//l2指针向后移动
            ptr = head;
        }
        //ptr为最后一个节点
        while ((l1_ptr != null) || (l2_ptr != null)){
            if(l1_ptr == null){
                ptr.next = l2_ptr;
                break;
            }
            if(l2_ptr == null){
                ptr.next = l1_ptr;
                break;
            }
            if (l1_ptr.val <= l2_ptr.val){
                ptr.next = l1_ptr;
                l1_ptr = l1_ptr.next;//l1指针向后移动
                ptr = ptr.next;
            }else {
                ptr.next = l2_ptr;
                l2_ptr = l2_ptr.next;//l2指针向后移动
                ptr = ptr.next;
            }
        }
        return head;
    }
    public ListNode generateList(int[] ints){
        ListNode head,ptr;
        head = new ListNode(ints[0]);
        ptr = head;
        for (int i = 1; i < ints.length; i++) {
            ptr.next = new ListNode(ints[i]);
            ptr = ptr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Day12 day12 = new Day12();
        ListNode A = day12.generateList(new int[]{1,2,4});
        ListNode B = day12.generateList(new int[]{1,3,4});
        ListNode result = day12.mergeTwoLists(A,B);
        System.out.println(result);
    }
}
