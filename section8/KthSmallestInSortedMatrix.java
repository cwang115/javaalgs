package section8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    /**
     * Assumptions:
     *  1) Matrix is not null, N * M where N > 0 and M > 0
     *  2) k > 0 and k <= N * M
     * BFS
     * create a customized cell class to record visited or not
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {

        // set the boundary
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];


        //use minHeap
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell o1, Cell o2){
                if(o1.val == o2.val){
                    return 0;
                }

                return o1.val < o2.val ? -1 : 1;
            }
        });
        //offer the first cell
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for(int i = 0; i < k -1; i++){
            Cell cur = minHeap.poll();
            if(cur.row + 1< rows && !visited[cur.row + 1][cur.column]){
                minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row+ 1][cur.column]));
                visited[cur.row+ 1][cur.column] = true;
            }

            if(cur.column + 1< columns && !visited[cur.row][cur.column + 1]){
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }

        return minHeap.peek().val;
    }


    static class Cell{
        int row;
        int column;
        int val;

        public Cell(int row, int column, int val){
            this.row = row;
            this.column = column;
            this.val = val;
        }

    }
}
