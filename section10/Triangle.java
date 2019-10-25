package section10;

import java.util.List;

public class Triangle {

  public int minimumTotal(List<List<Integer>> triangle){
      if(triangle == null){
          throw new IllegalArgumentException();
      }

      int len = triangle.size();
      int[][] dp = new int[len][len];

      for(int i = 0; i < len; i++){
          dp[len - 1][i] = triangle.get(len-1).get(i);
      }

      for(int i = len -2; i >= 0; i--){
          for(int j = 0; j <= i; j++){
              dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]+triangle.get(i).get(j));
          }

      }
      return dp[0][0];
  }

    /**
     * recursion
     */
  public int minimalTotalII(int[][] matrix){
      //cc
      return minimalTotalII(0,0, matrix);
  }

  private int minimalTotalII(int i, int j, int[][] matrix){
      int n = matrix.length;
      if(i == n) {
          return 0;
      }

      int left = minimalTotalII(i, j, matrix);
      int right = minimalTotalII(i+ 1, j, matrix);
      return Math.min(left,right) + matrix[i][j];
  }

    /**
     * Recursion with pruning
     */

    private int minimumTotalIII(int[][] matrix){
        //cc
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        return minimumTotalIII(0,0, dp, matrix);
    }

    private int minimumTotalIII(int i, int j, Integer[][] dp, int[][] matrix){
        if(i == matrix.length){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        int left = minimumTotalIII(i+1, j, dp, matrix);
        int right = minimumTotalIII(i+1, j+ 1, dp, matrix);
        dp[i][j] = Math.min(left,right) + matrix[i][j];
        return dp[i][j];
    }
}

