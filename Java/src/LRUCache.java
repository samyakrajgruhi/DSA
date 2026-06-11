import java.util.HashMap;
import java.util.Map;

class CacheNode{
    int key;
    int value;
    CacheNode next;
    CacheNode prev;
    public CacheNode(int key,int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}

public class LRUCache {
    private void remove(CacheNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(CacheNode node){
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    int cap;
    Map<Integer, CacheNode> cacheMap = new HashMap<>();
    CacheNode head = new CacheNode(0,0);
    CacheNode tail = new CacheNode(0,0);

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cacheMap.containsKey(key)) return -1;
        CacheNode node = cacheMap.get(key);

        remove(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            CacheNode node = cacheMap.get(key);
            node.value = value;
            remove(node);
            addNode(node);
        }else{
            if(cacheMap.size() >= cap){
                CacheNode lruNode = tail.prev;
                remove(lruNode);
                cacheMap.remove(lruNode.key);
            }
            CacheNode newNode = new CacheNode(key,value);
            addNode(newNode);
            cacheMap.put(key,newNode);
        }
    }

}

class MainClass{
    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
