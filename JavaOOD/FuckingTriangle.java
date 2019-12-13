package JavaOOD;

import java.util.Arrays;

public class FuckingTriangle {

    //n

    /**
     *
     * @param n
     * {}
     * {0}
     * {0, 0}
     * {0, 0, 0}
     */
    public int[][] createTriangle(int n){
        int[][] matrix = new int[n][];
        for(int i = 0; i < n; i++){
            matrix[i] = new int[i];
            for(int j = 0; j < i; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
        return matrix;
    }

    public static void print2D(int[][] mat)
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }

    public static void printTriangle(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");

        }
    }


    public void printReverseTriangle(int n){
        int[][] matrix = new int[n][];
        for(int i = 0; i < n; i++){
            matrix[i] = new int[n-1-i];
            for(int j = 0; j< i; j++){
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
    public static void main(String[] args){

        FuckingTriangle solution = new FuckingTriangle();
        solution.printReverseTriangle(4);


    }
}
