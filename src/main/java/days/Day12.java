package days;

import java.util.HashMap;
import java.util.Stack;

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
    //栈实现，慢
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode ptr = headA;
        while (ptr!=null){
            stackA.push(ptr);
            ptr = ptr.next;
        }
        ptr = headB;
        while (ptr!=null){
            stackB.push(ptr);
            ptr = ptr.next;
        }
        ListNode A = stackA.pop();
        ListNode B = stackB.pop();
        ListNode result = A==B ? A : null;
        if (result==null) return result;
        while (true){
            if (stackA.empty() || stackB.empty()) return result;
            A = stackA.pop();
            B = stackB.pop();
            if (A != B) {
                return result;
            }else {
                result = A;
            }
        }
    }
    //哈希表实现,居然更慢，wc
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer>  map = new HashMap<>();
        ListNode ptr = headA;
        while (ptr!=null){
            map.put(ptr,1);
            ptr = ptr.next;
        }
        ptr = headB;
        while (ptr!=null){
            if (map.containsKey(ptr)){
                return ptr;
            }
            ptr = ptr.next;
        }
        return null;
    }
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode A = headA,B = headB;
        while (A  != B ){
            //题解：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/jian-zhi-offer-52-liang-ge-lian-biao-de-gcruu/
            //牛，两个链表在公共节点之前
            A = A==null ? headB : A.next;
            B = B==null ? headA : B.next;
        }
        return A;
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
    public void combine(ListNode A,ListNode B,ListNode com){
        ListNode ptr = A;
        while (true){
            if (ptr.next==null) break;
            else ptr = ptr.next;
        }
        ptr.next = com;
        ptr = B;
        while (true){
            if (ptr.next==null) break;
            else ptr = ptr.next;
        }
        ptr.next = com;
    }
    public static void main(String[] args) {
        Day12 day12 = new Day12();
        ListNode comm = day12.generateList(new int[]{8,4,5});
        ListNode A = day12.generateList(new int[]{4,1});
        ListNode B = day12.generateList(new int[]{5,0,1});
        day12.combine(A,B,comm);
        System.out.println(A);
        System.out.println(B);
        day12.getIntersectionNode3(A,B);
    }
}
