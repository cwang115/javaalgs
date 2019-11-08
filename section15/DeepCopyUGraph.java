package section15;


import section16.GraphNode;
import section15.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static section15.Node.addEdge;
import static section15.Node.printAdjacencyList;

public class DeepCopyUGraph{

    public List<GraphNode> copy(List<GraphNode> graph){
        if(graph == null){
            return null;
        }

        Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
        for(GraphNode node : graph){
            if(!map.containsKey(node)){
                map.put(node, new GraphNode(node.value));
                DFS(node, map);
            }
        }
        return new ArrayList<GraphNode>(map.values());
    }

    private void DFS(GraphNode seed, Map<GraphNode, GraphNode> map){
        GraphNode copy = map.get(seed);
        for(GraphNode nei: seed.neighbors){
            if(!map.containsKey(nei)){
                map.put(nei, new GraphNode(nei.value));
                DFS(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }

    }






    public static void main(String[] args){
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        printAdjacencyList(adj);
    }


}

