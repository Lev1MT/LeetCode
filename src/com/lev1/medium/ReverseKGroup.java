package com.lev1.medium;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseKGroup {

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
        System.out.println(reverseKGroup(node1, 2));
    }

    /**
     * 按照K步长翻转单链表
     * @param head 需要翻转的单链表
     * @param k 步长
     * @return 翻转结果
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;

        // 截取单链表
        for (int i = 1; i < k && temp!= null; i++) {
            temp = temp.next;
        }
        // 当剩下的节点数不足步长数时，不进行翻转
        if (temp == null) return head;

        // 保存剩余待翻转节点
        ListNode t2 = temp.next;
        temp.next = null;
        // 翻转截取出来的链表
        ListNode newHead = reverse(head);
        // 递归翻转
        ListNode tail = reverseKGroup(t2, k);
        // 将翻转之后的链表连接起来
        head.next = tail;
        return newHead;
    }

    /**
     * 单链表反转
     * @param head 需要反转的链表
     * @return 反转之后的链表
     */
    public static ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode target = null;
        while (temp != null){
            ListNode cur = temp.next;
            temp.next = target;
            target = temp;
            temp = cur;
        }
        return target;
    }
}