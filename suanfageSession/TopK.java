package suanfageSession;

import java.util.*;

public class TopK {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //use minHeap
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (o1, o2) -> map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o1) - map.get(o2));

        for(String word : map.keySet()){
            minHeap.offer(word);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<String> topK = new ArrayList<>();
        while(!minHeap.isEmpty()){
            topK.add(minHeap.poll());
        }

        Collections.reverse(topK);
        return topK;

    }

    public static void main(String[] args){
        String a1 = "a";
        String b1 = "b";

        int result = a1.compareTo(b1);
        int result2 = b1.compareTo(a1);
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (w1, w2) -> w2.compareTo(w1)
        );
        String[] list = {"c", "b", "a", "d"};
        for(String st : list){
            minHeap.offer(st);
        }

        System.out.println( a1.compareTo(b1));
        System.out.println( b1.compareTo(a1));
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }

    }
}
