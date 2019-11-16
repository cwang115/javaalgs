package suanfage2pointers;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V>{
    //each node contains the key, value pair
    //and it is also a double linked list node


    //define the Node (doubly linked list)
    //you should be able to update the node
    //each node contains a key value pair
    static class Node<K, V>{
        Node<K,V> next;
        Node<K,V> prev;
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        void update(K key, V value){
            this.key = key;
            this.value = value;
        }
    }



    //fields
    //make it final for the pre-defined size of the cache
    private final int limit;
    //record all the time the head and tail of the double linked list
    Node<K, V> head;
    Node<K, V> tail;
    //maintains the relationship of key and its corresponding node
    //in the doubly linked list
    private Map<K, Node<K, V>> map;

    //constructor
    public LRUCache(int limit){
        this.limit = limit;
        this.map = new HashMap<K, Node<K, V>>();
    }

    public void set(K key, V value){
        Node<K, V> node = null;
        //1. if the key already in the cache. we
        //need to update its value
        //and move it to head(most recent position)
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if(map.size() < limit){
            //2. if the key is not in the cache we still have space,
            //we can add append a new node to head
            node = new Node<K, V>(key, value);
        } else {
            //3. if the key is not in the cache and we don't have space
            // we need to evict the tail and reuse the node let it maintain
            //the new key, value and put it to head
            node = tail;
            remove(node);
            node.update(key, value);
        }

        append(node);
    }

    public V get(K key){
        Node<K, V> node = map.get(key);
        if(node == null){
            return null;
        }
        //even it is a read operation, it is still a write operation
        // to the double linked list, we need to move the node to head
        remove(node);
        append(node);
        return node.value;

    }

    private Node<K, V> remove(Node<K, V> node){
        map.remove(node.key);
        if(node.prev != null){
            node.prev.next = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }
        //maintain the head
        if(node == head){
            head = head.next;
        }

        //maintain the tail
        if(node == tail){
            tail = tail.prev;
        }

        node.next = node.prev = null;
        return node;


    }

    private Node<K, V> append(Node<K, V> node){
        map.put(node.key, node);
        if(head == null){
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }

    public static void main(String[] args){
        Node node = new Node(1, 2);
        System.out.println(node.key);

    }

}
