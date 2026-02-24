class ListNode{
    int value;
    ListNode next;
    ListNode(int value){
        this.value = value;
    }
}

public class LinkedList {
    public static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode reverseLinkedList(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode node = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    public static int middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n>0){
            fast = fast.next;
            n--;
        }
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast= fast.next;
        }
        System.out.println(slow.value);
        slow.next = slow.next.next;

        return dummy.next;
    }
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);


        n1.next = n2;


        ListNode head = n1;

        head = removeNthFromEnd(head,2);
        print(head);

    }
}
