package dp;

import java.util.*;

public class WordBreak {


    public static boolean wordBreak(String s, List<String> wordDict){
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<String>(wordDict);
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String cur = s.substring(j, i);  // [j, i)
                System.out.println(cur );
                System.out.println("j " + j );
                System.out.println("dp[j] " + dp[j]);
                if(dict.contains(cur) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }

    public static void main(String[] args){
        String s = "flow";
        String[] list = new String[]{"cats","dog","sand","and","cat"};
        List<String> dict = Arrays.asList(list);

        System.out.println(wordBreak(s, dict));
        System.out.println(s.indexOf("flower"));

    }
}
