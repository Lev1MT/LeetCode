package com.lev1.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private Integer capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}


class LRUCache2 {
    private DLinkedNode head, tail;
    private int size, capacity;
    private Map<Integer, DLinkedNode> map = new HashMap<>();

    class DLinkedNode {
        public int key, value;
        public DLinkedNode prev, next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkedNode() {
        }
    }

    // 向链表中插入节点，每次插入都放在head节点后面
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 删除指定节点
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // 将节点移动到双向链表头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        DLinkedNode newNode = new DLinkedNode(key, value);
        addNode(newNode);
    }
}