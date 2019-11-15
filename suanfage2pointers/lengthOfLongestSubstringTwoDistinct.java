package suanfage2pointers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n < 3){
            return n;
        }

        //use hashmap to keep track of the distinct Character {character = index}
        Map<Character, Integer> map = new HashMap<>();
        //sliding window left right pointer
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while( right < n){

            if(map.size() < 3){
                map.put(s.charAt(right), right++);
            }

            int delIndex = 0;
            if(map.size() == 3){
                //delete the leftmost index from map
                delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                left = delIndex+1;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;


    }

    public static void main(String[] args){
        lengthOfLongestSubstringTwoDistinct solution = new lengthOfLongestSubstringTwoDistinct();
        int result = solution.lengthOfLongestSubstringTwoDistinct("eeeeeceba");
        System.out.println(result);
    }
}
