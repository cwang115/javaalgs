package section11;

import java.util.Arrays;

public class SpiralGenerate {
    public int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];
        if(n == 0){
            return matrix;
        }

        int startIndex = 0;
        int endIndex = n - 1;
        int num = 1;
        while(startIndex < endIndex){

            for(int i = startIndex; i <= endIndex; i++){
                matrix[startIndex][i] = num++;
            }

            for(int i = startIndex + 1; i <= endIndex - 1; i++){
                matrix[i][endIndex] = num++;
            }

            for(int i = endIndex; i >= startIndex; i--){
                matrix[endIndex][i] = num++;
            }

            for(int i = endIndex - 1; i >= startIndex + 1; i--){
                matrix[i][startIndex] = num++;
            }

            startIndex++;
            endIndex--;
        }

        //postprocessing
        if(startIndex == endIndex){
             matrix[startIndex][endIndex] = num++;
        }
        return matrix;

    }

    public static void main(String[] args){
        SpiralGenerate solution = new SpiralGenerate();

        int[][] matrix = solution.generateMatrix(3);
        System.out.println(Arrays.deepToString(matrix));
    }

}
