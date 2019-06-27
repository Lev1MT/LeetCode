package com.lev1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Stack;

public class TwoSumOfLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(9);
        ListNode node16 = new ListNode(9);
        ListNode node17 = new ListNode(9);
        ListNode node18 = new ListNode(3);
        ListNode node19 = new ListNode(9);
        ListNode node20 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        node17.next = node18;
        node18.next = node19;
        node19.next = node20;
        ListNode node = addTwoNumbersOwn(node1, node11);
        ListNode node21 = addTwoNumbers(node1, node11);
        System.out.println(node21);
        System.out.println(node);
    }

    // 正确解法和思路
    // 1.假设两个链表长度一致，依次遍历链表元素，为空位置补0
    // 2.定义两个辅助节点，一个节点用来移动，另一节点用来存放结果数据
    // 3.定义一个进位标志carry
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1==null? 0:l1.val;
            int y = l2==null? 0:l2.val;
            int sum = x+y+carry;
            carry = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null)l1= l1.next;
            if (l2!= null)l2 = l2.next;
        }

        if (carry > 0){
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }

    // 自己的解法
    // 1.先将节点值压入栈中，然后顺序取出，汇总
    // 2.计算和，然后将和分拆到ListNode中
    // 此方法不可行，在leetcode环境下没有BigDecimal类
    public static ListNode addTwoNumbersOwn(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        while (l1 != null) {
            stack.add(l1.val);
            l1 = l1.next;
        }
        StringBuffer val1 = new StringBuffer("");
        while (stack.size()>0){
            val1.append(stack.pop());
        }
        while (l2 != null) {
            stack.add(l2.val);
            l2 = l2.next;
        }
        StringBuffer val2 = new StringBuffer("");
        while (stack.size()>0){
            val2.append(stack.pop());
        }

        BigDecimal sum = new BigDecimal(val1.toString()).add(new BigDecimal(val2.toString()));

        String[] strs = String.valueOf(sum.toPlainString()).split("");
        ListNode node = null;
        for (int i = 0; i < strs.length; i++) {
            ListNode newNode = new ListNode(Integer.parseInt(strs[i]));
            newNode.next = node;
            node = newNode;
        }

        return node;
    }
}

class ListNode {
    ListNode(int x) {
        val = x;
    }

    int val;
    ListNode next;

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                "," + next +
                '}';
    }
}