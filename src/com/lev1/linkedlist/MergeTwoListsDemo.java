package com.lev1.linkedlist;

public class MergeTwoListsDemo {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        } else if (l2 == null){
            return l1;
        } else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        ListNode preHead = new ListNode(-1);

        ListNode pre = preHead;


        while (l1.next != null || l2.next != null){
            if (l1.val < l2.val){

            }
        }

        return l1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}