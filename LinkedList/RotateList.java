package LinkedList;

public class RotateList {

    private int getLength(ListNode head){
        if(head == null){
            return 0;
        }

        return 1 + getLength(head.next);
    }


}
