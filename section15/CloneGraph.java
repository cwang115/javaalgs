package section15;
//TODO



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static section15.Node.addEdge;
import static section15.Node.printAdjacencyList;

public class CloneGraph {
    /**
     * 1
     */
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        return dfs(node, map);

    }

    private Node dfs(Node node, Map<Node, Node> map){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }

        map.put(node, new Node(node.val, new ArrayList<Node>()));
        for(Node nei : node.neighbors){

            map.get(node).neighbors.add(dfs(nei, map));

        }



        return map.get(node);

    }

    /**
     * 2
     */
    public Node cloneGraphII(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        map.put(node, new Node(node.val, new ArrayList<Node>()));
        DFS(node, map);
        return map.get(node);

    }

    private void DFS(Node seed, Map<Node, Node> map){
//        if(seed == null){
//            return;
//        }
        Node copy = map.get(seed);
        for(Node nei: seed.neighbors){
            if(!map.containsKey(nei)){
                map.put(nei, new Node(nei.val, new ArrayList<Node>()));
                DFS(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }

    }
    public static Node buildGraph(){
         /*
            Note : All the edges are Undirected

        */
         Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
//        Node node7 = new Node(7, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
//        node2.neighbors.add(node7);
//        node2.neighbors.add(node3);
//        node3.neighbors.add(node7);
//        node6.neighbors.add(node7);
        return node1;

    }


    public static void main(String[] args){
        CloneGraph solution = new CloneGraph();
        Node node = buildGraph();

        solution.cloneGraphII(node);
    }
}
