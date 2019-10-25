package section11;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("Duplicates")
public class SpiralII {
    /**
     * matrix N * N iterative
     * @param matrix
     * @return
     */
    public List<Integer> spiralII(int[][] matrix){
        List<Integer> result = new ArrayList<Integer>();
        //corner case check null
        if(matrix == null){
            return result;
        }


        int len = matrix.length;
        if(len == 0){
            return result;
        }

        int startIndex = 0;
        int endIndex = len - 1;

        while(startIndex < endIndex){
            for(int i = startIndex; i <= endIndex; i++){
                result.add(matrix[startIndex][i]);
            }

            for(int i = startIndex + 1; i <= endIndex - 1; i++){
                result.add(matrix[i][endIndex]);
            }
            for(int i = endIndex; i >= startIndex;i--){
                result.add(matrix[endIndex][i]);
            }

            for(int i = endIndex - 1; i >= startIndex + 1; i--){
                result.add(matrix[i][startIndex]);
            }

            endIndex--;
            startIndex++;
        }

        //post processing
        if(startIndex == endIndex){
            result.add(matrix[startIndex][endIndex]);
        }

        return result;


    }
}
