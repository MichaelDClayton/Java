package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class AddTwoNumbers {
	private class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public static void main(String[] args) {
		AddTwoNumbers a = new AddTwoNumbers();
		//342
		ListNode listAThree = a.new ListNode(3);
		ListNode listATwo = a.new ListNode(4, listAThree);
		ListNode listAOne = a.new ListNode(2, listATwo);
		
		//465
		ListNode listBThree = a.new ListNode(4);
		ListNode listBTwo = a.new ListNode(6,listBThree);
		ListNode listBOne = a.new ListNode(5,listBTwo);
		
		
		
		
		
		
		ListNode res = a.addTwoNumbers(listAOne,listBOne);
		
		ListNode holder = res;
		while(holder!=null) {
			System.out.println(holder.val);
			holder = holder.next;
		}
		
	}
	
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		 ListNode dummyHead = new ListNode(0);
			ListNode curr = dummyHead;
			int carry = 0;

			while (l1 != null || l2 != null) {
				int x = (l1 != null) ? l1.val : 0;
				int y = (l2 != null) ? l2.val : 0;

				int sum = carry + x + y;
				carry = sum / 10;
				curr.next = new ListNode(sum % 10);
				curr = curr.next;
				if (l1 != null)
					l1 = l1.next;
				if (l2 != null)
					l2 = l2.next;
			}
			if (carry > 0) {
				curr.next = new ListNode(carry);
			}

			return dummyHead.next;		
	}
	
}
