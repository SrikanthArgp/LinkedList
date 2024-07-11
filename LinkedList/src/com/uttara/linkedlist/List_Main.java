package com.uttara.linkedlist;

public class List_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList linkedList = new LinkedList();
		linkedList.append(4);
		linkedList.append(18);
		linkedList.append(7);
		linkedList.append(3);
		linkedList.append(67);
		linkedList.append(39);
		linkedList.append(43);
		linkedList.traverse();
		System.out.println("Size of the LL : " +linkedList.getSize());
		
		System.out.println("After Deletion");
		linkedList.delete(4);
		linkedList.delete(43);
		linkedList.traverse();
		System.out.println("Is LL length Even :  " +linkedList.isLinkedListEvenLength());
		System.out.println("Get Middle Node : " +linkedList.getMiddle().getData());
		
		//Print the list in reverse order
		System.out.println("Print Reverse");
		linkedList.printReverse();
		System.out.println();
		linkedList.traverse();
		
		// Reverse Linked List
		System.out.println("Reversing Linked List");
		linkedList.reverse();
		linkedList.traverse(); 
		
		// Reverse Listed List recursively
		System.out.println("Recursive Reverse");
		linkedList.reverseRecursive();
		linkedList.traverse();
		
		System.out.println("Reverse K items : ");
		LinkedList l = new LinkedList();
		for(int i=1;i<24;i++)
			l.append(i);
		l.reverseKAlt(5);
		l.traverse();
	
			
	}

}
