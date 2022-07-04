package algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Dan.L
 * @date 2022年07月04日15:43
 */
public class lru {
    Entry head, tail;
    int capacity;
    int size;
    Map<Integer, Entry> cache;

    @Override
    public String toString() {
        return "lru{" +
            "head=" + head.value +
            ", tail=" + tail.value +
            ", capacity=" + capacity +
            ", size=" + size +
            ", cache=" + cache.values() +
            '}';
    }

    public lru(int capacity) {
        this.capacity = capacity;
        // 初始化链表
        initLinkedList();
        size = 0;
        cache = new HashMap<>(capacity + 2);
    }

    /**
     * 如果节点不存在，返回 -1.如果存在，将节点移动到头结点，并返回节点的数据。
     *
     * @param key
     * @return
     */
    public int get(int key) {
        Entry node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 存在移动节点 0 1 2 0
        System.out.println("get node ===>" + node.value);
        moveToHead(node);
        return node.value;
    }

    /**
     * 将节点加入到头结点，如果容量已满，将会删除尾结点
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Entry node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        // 不存在。先加进去，再移除尾结点
        // 此时容量已满 删除尾结点
        if (size == capacity) {
            Entry lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }
        // 加入头结点

        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key, newNode);
        size++;

    }

    private void moveToHead(Entry node) {
        // 首先删除原来节点的关系
        deleteNode(node);
        // 添加新的节点
        addNode(node);
    }

    private void addNode(Entry node) {
        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;
    }

    // 0 0 2   2 1 0
    private void deleteNode(Entry node) {
        //  null 0 1 ,0 1 0, 1 0 null
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    public static class Entry {
        public Entry pre;
        public Entry next;
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }
    }

    /**
     * 初始化链表，设置好头尾节点
     */
    private void initLinkedList() {
        head = new Entry();  //头节点
        tail = new Entry();  //尾巴节点
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        lru cache = new lru(2);
        System.out.println("=====cache init===="+cache.toString());
        //  null 0 1 ,0 1 0, 1 0 null
        cache.put(1, 1);
        //   null 0 2, 0 2 1, 2 1 0
        cache.put(2, 2);
        System.out.println("=====cache===="+cache.toString());
        System.out.println(cache.get(1));
        System.out.println("=====cache get===="+cache.toString());

        cache.put(3, 3);
        System.out.println(cache.get(2));

    }
}


