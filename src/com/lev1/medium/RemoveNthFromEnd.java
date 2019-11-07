package com.lev1.medium;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 示例： 给定一个链表: 1->2->3->4->5, 和 n = 2. 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(removeNthFromEnd(node1, 2));
    }

    /**
     * 删除链表倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode cur = dummy;

        //找到倒数第n+1个节点
        for (int i = 0; i < size - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}