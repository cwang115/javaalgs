package suanfageTree;

import java.lang.reflect.Array;
import java.util.*;
//DFS
//indegree

/**
 * DFS
 * Indegree
 *
 */
public class CourseSchedule {

    enum State {UNVISITED, VISITING, VISITED}

    public int[] findOrder(int numCourse, int[][] prerequisites) {
        Deque<Integer> stack = new LinkedList<>();


        // build adj list(modular)
        Map<Integer, List<Integer>>  adjList = buildAdjList(numCourse, prerequisites);



        // build node state
        State[] nodeStates = new State[numCourse];
        Arrays.fill(nodeStates, State.UNVISITED);

        // dfs on unvisited nodes, pass in the order stack
        //TODO critical part
        try{
            for(int i = 0; i < numCourse; i++){
                if(nodeStates[i] == State.UNVISITED){
                    dfs(stack, nodeStates, adjList, i);
                }
            }
        } catch (IllegalArgumentException ex){
            return new int[0];
        }

        //return new int[] result
        int [] result = new int[numCourse];
        int i = 0;
        while(!stack.isEmpty()){
            result[i++] = stack.pollFirst();
        }

        return result;

    }

    public Map<Integer, List<Integer>> buildAdjList(int numCourse, int[][] prerequisites){
        //cc
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < numCourse; i++){
            List<Integer> lst = adjList.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            lst.add(prerequisites[i][0]);
            adjList.put(prerequisites[i][1], lst);
        }
        return adjList;
    }

    public void dfs(Deque<Integer> stack, State[] states, Map<Integer, List<Integer>> adjList, int node){
        //termination

        if(states[node] == State.VISITED){
            return;
        }

        if(states[node] == State.VISITING){
            throw new IllegalArgumentException(); //cyclic
        }

        states[node] = State.VISITING;

        for(Integer adjNode : adjList.keySet()){
            dfs(stack, states, adjList, adjNode);
        }

        states[node] = State.VISITED;
        stack.add(node);
    }

}
