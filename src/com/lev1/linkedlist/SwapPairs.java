package com.lev1.linkedlist;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 示例: 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

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
        System.out.println(swapPairs(node1));

        System.out.println(swapPairs2(node2));
    }

    /**
     * 递归实现链表两两翻转
     *
     * @param head 需要翻转的链表
     * @return 翻转后的链表
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    /**
     * 非递归实现链表两两翻转
     *
     * @param head 需要翻转的链表
     * @return 翻转后的链表
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}