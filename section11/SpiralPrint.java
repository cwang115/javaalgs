package section11;
import java.util.ArrayList;
import java.util.List;

/**
 * Matrix is not null, has size M * N , where M * N >= 0
 */
public class SpiralPrint {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int rowNum = matrix.length;
        if(rowNum == 0){
            return result;
        }
        int columnNum = matrix[0].length;
        int left = 0;
        int right = columnNum - 1;
        int up = 0;
        int down = rowNum - 1;


        //the base case is a little complicated comparing to N*N matrix
        //1. there is nothing left
        //2. there is one row left;
        //3. there is one column left;

        while(left < right && up < down){
            for(int i = left; i <= right; i++){
                result.add(matrix[up][i]);
            }

            for(int i = up + 1; i <= down - 1; i++){
                result.add(matrix[i][right]);
            }

            for(int i = right; i>= left; i--){
                result.add(matrix[down][i]);
            }

            for(int i = down - 1; i >= up + 1; i--){
                result.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }

        //1. if there is nothing left
        if(left == right){
            return result;
        }

        //2. if there is one column left;
        if(left == right){
            for(int i = up; i<= down; i++){
                result.add(matrix[i][left]);
            }
        }else{
            //3.if there is one row left
            for(int i =left; i <= right; i++){
                result.add(matrix[up][i]);
            }
        }
        return result;

    }


    public static void main(String[] args){
        SpiralPrint solution = new SpiralPrint();
        int[][] matrix = new int[][]{{1, 2, 3, 4},
                { 5, 6, 7, 8}, {9, 10, 11, 12}};

        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result.toString());

    }
}
