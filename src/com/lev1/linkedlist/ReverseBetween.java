package com.lev1.linkedlist;

/**
 *
 */
public class ReverseBetween {

    public static ListNode successor = null;

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
        System.out.println(reverseN(node1, 3));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 翻转链表前n个节点
     *
     * @param head 需要翻转的链表
     * @param n    链表前多少个节点
     * @return 翻转后的链表
     */
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;

        head.next = successor;

        return last;
    }
}