import java.util.HashMap;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

class Node{
    int val;
    Node next;
    Node random;
    Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

@SuppressWarnings("ClassEscapesDefinedScope")
public class LinkedList {
    public static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void print2(Node head){
        while(head!=null){

            System.out.println("["+head.val+","+(head.random != null ? head.random.val : 0)+"]");
            head = head.next;

        }
    }

    public static int getLength(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }

        return length;
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

    public static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
        System.out.println(slow.val);
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void deleteNode(ListNode node){
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;

    }
    
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int remainder = 0;
        while(l1 != null && l2!=null){
            int sum = l1.val + l2.val;
            if(remainder>0){
                sum += 1;
                remainder = 0;
            }
            if(sum >= 10){
                remainder = 1;
                sum = sum%10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = l1.val;
            if(remainder>0){
                sum += 1;
                remainder = 0;
            }
            if(sum >= 10){
                remainder = 1;
                sum = sum%10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val;
            if(remainder>0){
                sum += 1;
                remainder = 0;
            }
            if(sum >= 10){
                remainder = 1;
                sum = sum%10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l2 = l2.next;
        }

        if(remainder>0){
            temp.next = new ListNode(remainder);
        }

        return head.next;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if(lengthA > lengthB){
            int diff = lengthA - lengthB;
            while(diff > 0){
                headA = headA.next;
                diff--;
            }
        }else {
            int diff = lengthB - lengthA;
            while(diff > 0){
                headB = headB.next;
                diff--;
            }
        }

        while(headA != headB && headA != null && headB != null){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static ListNode reverseKGroup(ListNode head,int k) {
        int length = getLength(head);
        if(length < k){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        for(int i=0;i<k;i++){
            temp = temp.next;
        }
        ListNode next = temp.next; // 3
        temp.next = null;
        dummy.next = reverseLinkedList(head);

        temp = dummy.next;
        while(temp.next!= null){
            temp = temp.next;
        }

        temp.next = reverseKGroup(next,k);

        return dummy.next;

    }

    public static ListNode removeNodes(ListNode head){
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;
        while(temp != null){
            while(!stack.isEmpty() && temp.val > stack.peek().val){
                stack.pop();
            }
            stack.push(temp);
            temp = temp.next;
        }

        while(!stack.isEmpty()){
            ListNode top = stack.pop();
            top.next = temp;
            temp = top;
        }

        return temp;

    }

    public static boolean isPalindrome(ListNode head){
        Stack<Integer> stack = new Stack<>();

        if(head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        while(head != slow){
            stack.push(head.val);
            head = head.next;
        }
        if(fast != null){
            head = head.next;
        }

        while(head != null){
            if(head.val == stack.peek()){
                stack.pop();
            }else{
                return false;
            }
            head = head.next;
        }

        return stack.isEmpty();
    }

    public static ListNode reverseBetween(ListNode head,int left,int right){
        if(head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        for(int i=0;i<left-1;i++){
            temp=temp.next;
        }
        ListNode end = dummy;
        for(int i=0;i<right;i++){
            end = end.next;
        }
        ListNode remaining = end.next;
        end.next = null;
        temp.next = reverseLinkedList(temp.next);
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = remaining;

        return dummy.next;
    }

    public static ListNode rotate(ListNode head){
        ListNode end = head;
        while(end.next.next!=null){
            end = end.next;
        }
        ListNode newHead = end.next;
        end.next = null;
        newHead.next = head;

        return newHead;
    }

    public static ListNode leftRotate(ListNode head,int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = getLength(head);
        k = k % len;
        for(int i=0;i<k;i++){
            dummy.next = rotate(dummy.next);
        }

        return dummy.next;
    }

    public static Node copyRandomList(Node head) {
        HashMap<Node,Node> nodes = new HashMap<>();

        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            nodes.put(temp,newNode);
            temp = temp.next;
        }

        temp = head;

        while(temp!=null){
            Node current = nodes.get(temp);
            current.next = nodes.get(temp.next);
            current.random = temp.random != null ? nodes.get(temp.random) : null;
            temp = temp.next;
        }

        Node newHead = nodes.get(head);

        return newHead;

    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.next == null && head.val == val){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while(temp!=null && temp.next!=null){
            print(dummy.next);
            if(temp.next.val == val){
                if(temp.next.next!=null){
                    temp.next = temp.next.next;
                }else{
                    temp.next = null;
                    break;
                }
            } else {
                temp = temp.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;


        ListNode head = removeElements(n1,6);

        print(head);

    }
}
