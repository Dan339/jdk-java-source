package algorithm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author Dan.L
 * @date 2022年07月04日17:22
 */
public class lru2 {
    static LinkedHashMap<Integer,Integer> cache = new LinkedHashMap();
    static int capacity;

    public lru2(int capacity){
        cache = new LinkedHashMap(capacity);
        this.capacity = capacity;
    }

    //获取
    public static int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        int val = cache.get(key);
        //删除此节点
        cache.remove(key);
        //添加新节点
        cache.put(key, val);
        return val;
    }

    //添加
    public static void put(int key, int value){
        //查看此节点是否存在
        if(cache.containsKey(key)){
            cache.remove(key);
        }
        // 判断容量
        if(capacity == cache.size()){
            // 删除链表头，也就是最少使用的数据
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        // 添加到链尾
        cache.put(key, value);
    }

    public static void main(String[] args) {
        lru2 lru2 = new lru2(2);
        lru2.put(1, 1);
        lru2.put(2, 2);
        lru2.put(3, 3);
    }
}
