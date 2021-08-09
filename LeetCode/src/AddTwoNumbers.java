/*
 * LeetCode 2.Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
	static AddTwoNumbers add = new AddTwoNumbers();

//	  Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	 public static String getNumbers(ListNode l) {
		 String numbers = "";
		 while(l!= null) {
			 numbers += l.val;
			 l = l.next;
		 }
		 
		 
		 
		 return new StringBuilder(numbers).reverse().toString();
		 
	 }
	 
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode dummyHead = add.new ListNode(0);
		 ListNode curr = dummyHead ;
		
		Double number1 = Double.valueOf(getNumbers(l1));
		Double number2 = Double.valueOf(getNumbers(l2));
		
		Double result = number1 + number2 ;
		
		
		if(result == 0) {
			return dummyHead;
		}else {
		
			while(result != 0 ) {
				curr.next = add.new ListNode(Integer.valueOf((int) (result%10)));
				curr = curr.next;
				result = result / 10;
			}
		}
		return dummyHead.next;
        
    }

	public static void main(String[] args) {
		ListNode l1 = add.new ListNode(3);

		
		ListNode r1 = add.new ListNode(9);
		ListNode r2 = add.new ListNode(9,r1);
		ListNode r3 = add.new ListNode(9,r2);
		ListNode r4 = add.new ListNode(9,r3);
		ListNode r5 = add.new ListNode(9,r4);
		ListNode r6 = add.new ListNode(9,r5);
		ListNode r7 = add.new ListNode(9,r6);
		ListNode r8 = add.new ListNode(9,r7);
		ListNode r9 = add.new ListNode(9,r8);
		ListNode r10 = add.new ListNode(3,r9);
		
		ListNode result = addTwoNumbers(l1, r10); 
		System.out.println(result.toString());
		
	}

}
