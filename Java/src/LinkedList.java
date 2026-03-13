import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
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

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head = n1;

        head = reverseBetween(head,2,4);
        print(head);





    }
}
