public class Add_Two_Numbers {
  
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0){
            int add = 0;
            if(l1 != null){
                add += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                add += l2.val;
                l2 = l2.next;
            }
            sum += add;
            ListNode curr = new ListNode(sum % 10);
            sum /= 10;
            current.next = curr; 
            current = current.next;
        }
        return temp.next; 
    }

    public static void main(String[] args) {
        ListNode l1 = createListNode(243); 
        ListNode l2 = createListNode(564); 
        ListNode sol = addTwoNumbers(l1, l2);
        printListNode(sol);
    }
    public static void printListNode(ListNode node){

        while(node != null){
            System.out.print(node.val);  
            node = node.next;
        }
        System.out.println();
    }
    public static ListNode createListNode(int num) {
        ListNode temp = new ListNode(0); 
        ListNode current = temp;
        while(num!=0){
            ListNode add = new ListNode(num%10);
            current.next = add;
            current = current.next;
            num /= 10;
        }
        return temp.next;
    }
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}