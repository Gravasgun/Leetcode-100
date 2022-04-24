import java.util.HashSet;
import java.util.Set;

/**
 * 160.相交链表
 * 给你两个单链表的头节点headA和headB,请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null。
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构。
 *
 * 思路和算法:
 * 判断两个链表是否相交，可以使用哈希集合存储链表节点。
 * 首先遍历链表headA，并将链表headA中的每个节点加入哈希集合中。然后遍历链表headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
 *
 * 如果当前节点不在哈希集合中，则继续遍历下一个节点；
 *
 * 如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都在两个链表的相交部分
 * 因此在链表headB中遍历到的第一个在哈希集合中的节点就是两个链表相交的节点，返回该节点。
 *
 * 如果链表headB中的所有节点都不在哈希集合中，则两个链表不相交，返回null。
 */
class ListNodeIntersection {
    int val;
    ListNode next;

    ListNodeIntersection(int x) {
        val = x;
        next = null;
    }
}

public class GetIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建hashset
        Set<ListNode> s = new HashSet<>();
        ListNode temp = headA;
        //遍历headA，并添加进hashset
        while (temp != null) {
            s.add(temp);
            temp = temp.next;
        }
        temp = headB;
        //判断headB的每个节点在不在hashset中，如果在，则当前节点以及当前节点之后的节点全都是相交链表，如果不在，移动到下一个节点
        while (temp != null) {
            if (s.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
