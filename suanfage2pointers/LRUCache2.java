package suanfage2pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class LRUCache2 {

    //implement a doubly linkedlist for deletion, insertion
    //implement a hashamp to maintain the nodes
    static class Node{
        //fields
        Integer key;
        Integer value;
        Node prev;
        Node next;

        //constructor
        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }

        void update(Integer key, Integer value){
            this.key = key;
            this.value = value;

        }
    }

    //fields
    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
       Node node = map.get(key);
       if(node == null){
           return -1;
       }
       remove(node);
       append(node);
       return node.value;

    }

    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if( map.size() < capacity){
            node = new Node(key, value);
        } else {
            node =tail;
            remove(node);
            node.update(key, value);
        }

        append(node);
    }


    private Node append(Node node){
        //cc
        if(node == null){
            return null;
        }
        //maintain the hashmap
        this.map.put(node.key, node);
        if(head == null){
            head = tail = node;
        }else{

            node.next = head;
            node = head.prev;
            head = node;
        }

        return node;



    }

    private Node remove(Node node){

        //cc
        if(node == null){
            return null;
        }

        //maintain the hashmap
        this.map.remove(node.key);

        if(node.prev != null){
            node.prev.next = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }

        //maintain the head and tail
        if(node == head){
            head = head.next;
        }

        if(node == tail){
            tail = tail.prev;
        }

        return node;
    }

    public static void main(String[] args){
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
    
        cache.put(2, 2);

        cache.get(1);

        cache.put(3, 3);    // evicts key 2

        cache.get(2);       // returns -1 (not found)

        cache.put(4, 4);    // evicts key 1

        cache.get(1);       // returns -1 (not found)

        cache.get(3);       // returns 3

        cache.get(4);       // returns 4

    }
}
