package section16;

import java.util.List;

public class GraphNode{
    public int value;
    public String name;
    public List<GraphNode> neighbors;

    public GraphNode(int value) {
        this.value = value;
    }

    public GraphNode(int value, List<GraphNode> neighbors){
        this.value = value;
        this.neighbors = neighbors;
    }


}