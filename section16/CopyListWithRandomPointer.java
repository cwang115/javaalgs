package section16;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode138
 */
public class CopyListWithRandomPointer {

    //method 1: using HashMap to avoid copy multiple times for the same node
    public Node copy(Node head){
        if(head == null){
            return null;
        }

        Node dummy = new Node(0);
        Node cur = dummy;

        //maintains the mapping between the node in the original list
        //and the corresponding node in the new list
        Map<Node, Node> map = new HashMap<>();
        while(head != null){
            if(!map.containsKey(head)){
                map.put(head, new Node(head.val));
            }
            //connect the copied node to the deep copy list
            cur.next = map.get(head);
            //copy the random node if necessary
            if(head.random != null){
                if(!map.containsKey(head.random)){
                    map.put(head.random, new Node(head.random.val));
                }

                // connect the copied node to the deep copy list
                cur.next.random = map.get(head.random);

            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        //old nodes as keys and new nodes as its values
        HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();
        Node dummy = new Node();

        //pointer to traverse the list
        Node cur = dummy;
        //traverse the original list
        while(head != null){
            //copy the current node if necessary
            if(!visitedHash.containsKey(head)){
                //visitedHash.put(head, new Node(head.val, null, null));
                visitedHash.put(head, new Node());
                visitedHash.get(head).val = head.val;
//                System.out.println(head.val);
//                System.out.println(visitedHash.get(head).val);

            }


            cur.next = visitedHash.get(head);
            //copy the random node if necessary
            if(head.random != null){
                if(!visitedHash.containsKey(head.random)){
                    visitedHash.put(head.random, new Node(head.random.val, null, null));
                }
                cur.next.random = visitedHash.get(head.random);
            }

            head = head.next;
            cur = cur.next;

        }

        return dummy.next;
    }


    public static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args){
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        Node node5 = new Node(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random =node5;
        node2.random = node1;
        node3.random = node4;
        node4.random = node4;
        Node newHead = solution.copyRandomList(node1);
        printList(node1);
        printList(newHead);
    }
}

