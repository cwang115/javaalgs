package section8;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class validParentheses {

    public boolean isValid(String s) {
       //use Hashmap
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Deque<Character> stack = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.offerFirst(cur);
            } else if (map.containsValue(cur)) {
                if (!stack.isEmpty() && map.get(stack.pollFirst()) == cur) {
                    stack.pollFirst();
                } else {
                    return false;
                }
            }
        }
            return stack.isEmpty();


        }



}
