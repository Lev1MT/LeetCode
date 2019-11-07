package com.lev1.linkedlist;

import com.lev1.linkedlist.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 示例 1: 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL 示例 2: 输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL 向右旋转 2 步: 1->2->0->NULL 向右旋转 3
 * 步: 0->1->2->NULL 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {

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
        System.out.println(rotateRight(node1, 2));
    }

    /**
     * 官方解答：
     * 先将链表形成一个环，然后根据 k 与链表长度取模来确定移动距离
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }
        ListNode temp = head;
        int n = 0;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        temp.next = head;

        // 特别注意这一步，n+1为链表长度，k%(n+1)是求出来的模，右移相当于尾部指针向后移动k次，等同于头部指针向前移动 n+1-(k%(n+1))次
        int step = n + 1 - (k % (n + 1));
        while (step > 0) {
            temp = temp.next;
            step--;
        }
        ListNode result = temp.next;
        temp.next = null;
        return result;
    }

    /**
     * 自己的解法，每次将链表右移一位，移动 k 次 影响：效率较低
     *
     * @param head 待确定链表
     * @param k    移动k次
     * @return 移动后的链表
     */
    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            temp = rotateRight1Step(temp);
        }
        return temp;
    }

    /**
     * 将链表右移一位
     *
     * @param head 待移动链表
     * @return 移动之后的链表
     */
    public static ListNode rotateRight1Step(ListNode head) {
        ListNode pre = head;

        while (pre.next.next != null) {
            pre = pre.next;
        }

        ListNode temp = pre.next;
        pre.next = null;
        temp.next = head;
        return temp;
    }
}