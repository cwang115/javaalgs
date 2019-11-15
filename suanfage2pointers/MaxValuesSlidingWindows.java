package suanfage2pointers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO
public class MaxValuesSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k){
    return null;
    }





    public static void main(String[] args)
    {

        // Creating an empty HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        Map<String, Integer> hashmap = new HashMap<>();
        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");

        hashmap.put("Geeks", 10);
        hashmap.put("4", 15);
        hashmap.put("4", 4);
        hashmap.put("4", 5);
        hashmap.put("Welcomes", 25);
        hashmap.put("You", 30);

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hashmap);

        // Using values() to get the set view of values
        System.out.println("The collection is: " + hash_map.values());

        System.out.println("The min value of hashmap " + Collections.min(hashmap.values()));

        System.out.println(hashmap.get("4"));
    }
}
