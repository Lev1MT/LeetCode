package com.lev1.hard;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKLists {

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
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(7);
        node6.next = node7;
        node7.next = node8;
        ListNode node9 = new ListNode(3);
        ListNode node10 = new ListNode(4);
        ListNode node11 = new ListNode(7);
        ListNode node12 = new ListNode(9);
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        ListNode node13 = new ListNode(6);
        ListNode node14 = new ListNode(10);
        node13.next = node14;
        System.out.println(mergeKLists(new ListNode[] {node1, node6, node9, node13}));
    }

    /**
     * 合并 k 个排序链表
     *
     * @param lists 待合并链表数组
     * @return 合并排序后的链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return startMergeLists(lists, 0, lists.length - 1);
    }

    /**
     * @param lists
     * @param left
     * @param right
     * @return
     */
    public static ListNode startMergeLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = startMergeLists(lists, left, mid);
        ListNode l2 = startMergeLists(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return l3.next;
    }
}