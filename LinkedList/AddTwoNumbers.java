package LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //cc
        boolean plusOne = false;
        int offset = 1;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int curVal = 0;
        while(cur1.next!= null && cur2.next != null){
            if(plusOne){
                curVal += offset;
                plusOne = false;
            }

            curVal += cur1.val + cur2.val;
            if(curVal < 10){
                cur1.val = curVal;

            }else{
                cur1.val = curVal - 10;
                plusOne = true;
            }

            cur1 = cur1.next;
            cur2 = cur2.next;
            curVal = 0;

        }

        return l1;
    }
}
