
public class Practice {
    public static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static ListNode reverseLL(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode node = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return  node;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        ListNode head = n1;

        head = reverseLL(head);

        print(head);


    }
}
