package com.lev1.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedListToBST {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(sortedListToBST2(node1));
    }

    /**
     * 通过递归，
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        // 找到mid节点
        ListNode mid = getMid(head);

        TreeNode node = new TreeNode(mid.val);

        if (head == mid) {
            return node;
        }

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }

    /**
     * 快慢指针查找链表中间节点
     * @param head
     * @return
     */
    public static ListNode getMid(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPre = null;
        while (fast != null || fast.next!= null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slowPre != null){
            slowPre.next = null;
        }
        return slow;
    }

    /**
     * 先将链表放入数组中，然后将数组转换为二叉树
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = linkedList2Array(head);
        return array2BST(list,0,list.size()-1);
    }

    public static List<Integer> linkedList2Array(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public static TreeNode array2BST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(list.get(mid));

        if (left == right) {
            return node;
        }

        node.left = array2BST(list, left, mid - 1);
        node.right = array2BST(list, mid + 1, right);

        return node;
    }
}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}