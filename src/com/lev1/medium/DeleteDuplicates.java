package com.lev1.medium;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(deleteDuplicates(node1));
    }

    /**
     * 移除链表中重复的数字，自己想的逻辑是，两个next域指向head的指针，一个用于输出结果，一个用于移动以删除重复节点，temp指针用户获取重复的节点直到不重复
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        ListNode temp = head;
        while (temp != null) {
            if (temp.next == null){
                break;
            }
            if (temp.val == temp.next.val){
                while (true) {
                    if (temp.next == null){break;}
                    if (temp.val != temp.next.val){break;}
                    temp = temp.next;
                }
                pre.next = temp.next;
                temp = temp.next;
            } else {
                pre = pre.next;
                temp = temp.next;
            }
        }

        return cur.next;
    }
}