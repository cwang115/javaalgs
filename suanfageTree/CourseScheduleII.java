package suanfageTree;

import java.util.*;

/**
 * Tested at leetcode
 */
public class CourseScheduleII {
    public enum Status{
        VISITING,
        UNVISITED,
        VISITED
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //cc
        //corner case, every numCourse is mentioned in prerequisites??


        //build a Status array to record it if it has been visited or not
        Status[] status = new Status[numCourses];
        Arrays.fill(status, Status.UNVISITED);

        //build a hashmap
        Map<Integer, List<Integer>> adjLists = buildAdjLists(prerequisites);

        //check acyclic use recursion
        try {
            for (Integer node: adjLists.keySet()) {
                dfs(node, adjLists, status);
            }
        } catch(Exception e){
            return false;
        }


        return true;

    }
    private Map<Integer, List<Integer>> buildAdjLists(int[][] prerequisites){
        //cc
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            int cur = prerequisites[i][1];
            List<Integer> lst = map.getOrDefault(cur, new ArrayList<Integer>());
            lst.add(prerequisites[i][0]);
            map.put(cur, lst);
        }
        return map;
    }

    private void dfs(Integer node, Map<Integer, List<Integer>> adjLists, Status[] status){
        //termination
        if(status[node] == Status.VISITED){
            return;
        }

        if(status[node] == Status.VISITING){
            throw new IllegalStateException("cycle");
        }

        status[node] = Status.VISITING;

        List<Integer> neighbors = adjLists.get(node);

        if(neighbors != null){
            for(Integer neighbor : neighbors){
                dfs(neighbor, adjLists, status);
            }
        }


        status[node] = Status.VISITED;

    }

    public static void main(String[] args){

            CourseScheduleII solution = new CourseScheduleII();
            int numCourses = 2;
            int[][] prerequisites = new int[][]{{2,0}};
            boolean result = solution.canFinish(numCourses, prerequisites);
            System.out.println(result);
        }

    }
