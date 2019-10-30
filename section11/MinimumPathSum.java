package section11;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 */
public class MinimumPathSum {
    //dfs
    //(i, j) either i+1 or j+1
    //if you happen to reach to the matrix[length-1][length-1] then return
    //pruning
    //find sum or path?
    public int findMinimumPathSum(int[][] matrix){
        //corner case
        if(matrix == null){
            return 0;
        }

        return dfs(0, 0, matrix);
    }

    private int dfs(int i, int j, int[][] matrix){
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        //termination
        if(i == rowLength - 1 && j==columnLength - 1){
            return matrix[i][j];
        }

        if(i < rowLength -1 && j < columnLength -1){
            int r1 = matrix[i][j] + dfs(i+1, j, matrix);
            int r2 = matrix[i][j] + dfs(i, j+1, matrix);
            return Math.min(r1, r2);
        }

        if(i < rowLength -1){
            return matrix[i][j] + dfs(i+1, j, matrix);
        }

        if(j < columnLength -1){
            return matrix[i][j] + dfs(i, j+1, matrix);
        }

        return 0;

    }

    /**
     * Dynamic Programming
     * O(n) space complexity
     */

    public int minPathSum(int[][] matrix){
        //base case


        int rowLen = matrix.length;
        int columnLen = matrix[0].length;


        int[][] dp = new int[rowLen][columnLen];
        dp[0][0] = matrix[0][0];

        for(int i = 1; i < rowLen; i++){
            dp[0][i] = matrix[0][i] + dp[0][i-1];
        }

        for(int i = 1; i < columnLen; i++){
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }


        for(int i = 1; i < rowLen; i++){
            for(int j = 1; j < columnLen; i++){
                if(dp[i][j-1] < dp[j-1][i]){
                    dp[i][j] = matrix[i][j] + dp[i][j-1];
                } else {
                    dp[i][j] = matrix[i][j] + dp[i-1][j];
                }
            }
        }

        return dp[rowLen - 1][columnLen - 1];






    }


}
