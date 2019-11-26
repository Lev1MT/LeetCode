package com.lev1.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 */
public class HasCycle {

    /**
     * 判断一个链表是否有环
     * 快慢指针：用一个慢指针从head节点开始遍历，快指针从head.net节点开始遍历，如果链表有环的话，快慢指针一定会相遇。
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 使用字典 Set 集合
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        Set<ListNode> listNodeSet = new HashSet<>();
        while (head.next != null){
            if (listNodeSet.contains(head)){
                return true;
            } else {
                listNodeSet.add(head);
                head= head.next;
            }
        }
        return false;
    }
}