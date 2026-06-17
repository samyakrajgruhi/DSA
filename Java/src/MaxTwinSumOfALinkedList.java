public class MaxTwinSumOfALinkedList {
    private static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }
    public static int length(ListNode head){
        int length = 0;
        ListNode temp = head;
        while(temp.next!=null){
            length++;
            temp = temp.next;
        }
        return length+1;
    }

    public static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static int pairSum(ListNode head){
        int sum = 0 ;
        int len = length(head);

        ListNode temp = head;
        ListNode twinHead = head;

        for(int i=0;i<len/2;i++){
            twinHead = twinHead.next;
        }

        twinHead = reverse(twinHead);

        for(int i=0;i<len/2;i++){
            int currentSum = temp.value + twinHead.value;
            sum = Math.max(sum,currentSum);
            temp = temp.next;
            twinHead = twinHead.next;
        }

        return  sum;
    }

    public static void main(String[] args){
        int[] values = {7,57,13,31,17,65,32,3,97,22,7,20,69,35,69,75,13,33,50,80,64,71,15,28,2,27,39,48,13,22,84,5,51,46,26,78,56,63};

        ListNode head = new ListNode(values[0]);
        ListNode temp = head;

        for(int i = 1; i < values.length; i++){
            temp.next = new ListNode(values[i]);
            temp = temp.next;
        }

        int answer = pairSum(head);
        System.out.println("Answer is :" + answer);
    }
}
