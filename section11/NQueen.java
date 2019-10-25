package section11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Each solution contains a distinct board configuration of the n-queens' placement,
 *  where 'Q' and '.' both indicate a queen and an empty space respectively
 */
public class NQueen {

    public List<List<String>> solveNQueens(int n){
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<List<String>>();
        solve(board, 0, result);
        return result;


    }

    private void solve(boolean[][] board, int i, List<List<String>> result){
        //termination
        if(i == board.length){
            addToResult(board, result);
            return;
        }

        for(int j = 0; j < board.length; j++){
            if(validPlace(board, i, j)){
                board[i][j] = true;
                solve(board,  i+1, result);
                board[i][j] = false;
            }
        }
    }

    private boolean validPlace(boolean[][] board, int i, int j){
        for(int x = 0; x < i; x++){
            for(int y=0; y < board.length; y++){
                if(board[x][y]){
                    //???????
                    if(y==j || y - (i - x) == i || y +(i -x) == j){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void addToResult(boolean[][] board, List<List<String>> result){
        List<String> currentConf = new ArrayList<>();
        for(int x=0; x<board.length; x++){
            StringBuilder row = new StringBuilder();
            for(int y=0; y<board.length;y++){
                if(board[x][y]){
                    row.append("Q");
                }else{
                    row.append(".");
                }
            }
            currentConf.add(row.toString());
        }
        result.add(currentConf);
    }



}
