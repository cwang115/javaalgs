package LinkedList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class AddTwoNumbersII {
    int c = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int len1 = 0;
        ListNode curr = l1;
        while(curr != null)
        {
            curr = curr.next;
            len1++;
        }
        int len2 = 0;
        curr = l2;
        while(curr != null)
        {
            curr = curr.next;
            len2++;
        }
        ListNode next = helper(len1, len2, l1, l2);
        if(c == 0)
            return next;
        else{
            ListNode start = new ListNode(c);
            start.next = next;
            return start;
        }
    }

    private ListNode helper(int remain1, int remain2, ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(remain1 > remain2){
            ListNode next = helper(remain1-1, remain2, l1.next, l2);
            int sum = l1.val + c;
            ListNode node = new ListNode(sum % 10);
            c = sum / 10;
            node.next = next;
            return node;
        } else if(remain1 < remain2) {
            ListNode next = helper(remain1, remain2-1, l1, l2.next);
            int sum = l2.val + c;
            ListNode node = new ListNode(sum % 10);
            c = sum / 10;
            node.next = next;
            return node;
        } else {
            ListNode next = helper(remain1-1, remain2-1, l1.next, l2.next);
            int sum = l1.val + l2.val + c;
            ListNode node = new ListNode(sum % 10);
            c = sum / 10;
            node.next = next;
            return node;
        }
    }

    public static void main(String[] args){
        AddTwoNumbersII solution = new AddTwoNumbersII();
        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(2)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode answer = solution.addTwoNumbers(l1, l2);
        System.out.println(answer);
    }

}
