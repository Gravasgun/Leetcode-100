/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */

//Definition for singly-linked list.
class ListNode {
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

public class mergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //首先定义一个新链表用于拼接
        ListNode list3 = new ListNode();
        //temp表示目前的节点位置
        ListNode temp = list3;
        //first表示头节点
        ListNode first = temp;
        //空判断
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        while (list1 != null && list2 != null) {
            //如果list1的值小
            if (list1.val <= list2.val) {
                //把list1赋给temp.next
                temp.next = list1;
                //list1往后移一位
                list1 = list1.next;
            }
            //list2的值小
            else{
                //把list2的值赋给temp.next
                temp.next = list2;
                //list2往后移一位
                list2 = list2.next;
            }
            //temp往后移一位
            temp = temp.next;
        }
        //最后将非空的list赋给temp.next
        temp.next = list1 == null ? list2 : list1;
        return first.next;
    }
}
