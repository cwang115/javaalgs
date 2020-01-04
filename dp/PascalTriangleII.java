package dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public List<Integer> getRowError(int rowIndex) {
        //List<List<Integer>> res  = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for(int index = 0; index < rowIndex; index++){
            cur.add(0, 1);
            for(int i = 1; i<rowIndex - 2 ;i++){
                cur.add(i, cur.get(i) + cur.get(i+1));
            }
            cur.add(1);
        }

        return cur;

    }

    public List<Integer> getRowII(int rowIndex) {

        //RowIndex starts at zero
        //O(n)
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0){
            return result;
        }
        //at zero index
        result.add(1);

        for(int i = 1; i <= rowIndex; i++){
            for(int j = result.size() - 2; j >= 0; j--){
                result.set(j+ 1, result.get(j) + result.get(j+1));
            }
            result.add(1);
        }


        return result;


    }

    public static void main(String[] args){
        PascalTriangleII solution = new PascalTriangleII();


    }
}
