package suanfageInterval;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //cc
        if(newInterval == null) return intervals;


        //init data
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        int n = intervals.length;
        List<int[]> res = new LinkedList<int[]>();

        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i++]);

        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);


        while(i < n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);

    }

    public static void main(String[] args){
        InsertInterval solution = new InsertInterval();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] res = solution.insert(intervals, newInterval);
        System.out.println(res);
    }
}
