package dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res  = new ArrayList<>();
        int index = 0;
        while(++index < numRows){
            List<Integer> cur = new ArrayList<>();
            if(res.size() == 0){
                cur.add(1);
            }else{
                cur.add(1);
                List<Integer> prev = res.get(res.size() - 1);
                for(int i = 1; i<index -1;i++){

                    int num=  prev.get(i) + prev.get(i - 1);
                    cur.add(num);
                }
                cur.add(1);

            }
            res.add(cur);

        }

        return res;

    }

    public static void main(String[] args){
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> res = solution.generate(5);
        System.out.println(res);

    }
}
