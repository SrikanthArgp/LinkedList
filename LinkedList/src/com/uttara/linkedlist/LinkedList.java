package com.uttara.linkedlist;

public class LinkedList {

	private Node head = null;
	private int size = 0;

	public LinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkedList(Node head) {
		//super();
		this.head = head;
	}

	protected Node getHead() {
		return head;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (null == head);
	}

	public int getSize() {
		return size;
	}

	public void append(int data) {
		// Create a new node
		Node newNode = new Node(data);
		// If it is the head node
		if (null == head) {
			head = newNode;
		} else {
			// Traverse till the end
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			// Append new node to last node
			temp.setNext(newNode);
		}
		size++;
	}

	public void insertBefore(int data) {
		// Create a new node
		Node newNode = new Node(data);
		// If it is the head node
		if (null == head) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}


	public void delete(int data) {
		// If no nodes in linked list
		if (head == null) {
			System.out.println("No elements in the list");
			return;
		}
		// if node to be deleted is head node
		if (head.getData() == data) {
			Node temp = head;
			head = head.getNext();
			temp.setNext(null);
			temp = null;
			size--;
			return;
		}

		else {
			Node previous = head;
			Node current = previous.getNext();
			// Traverse the list for node to be deleted
			while (current != null) {
				if (current.getData() == data) {
					// if found, set previous.next with current.next
					previous.setNext(current.getNext());
					current.setNext(null);
					size--;
					return;
				}

				previous = current;
				current = current.getNext();

			}
			// if node to be deleted is not found
			if (null == current) {
				System.out.println("No Specified element in the list");
			}
		}

	}

	public void traverse() {
		Node temp = head;
		// Traverse till the end node by node
		while (null != temp) {
			// display data in each node
			System.out.print(" " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println();
	}

	public void reverse() {
		// Set prev node with null and current with head
		Node prev = null;
		Node current = head;
		while (current != null) {
			// set temp node to current.next
			Node temp = current.getNext();
			// Point current.next to prev
			current.setNext(prev);
			// move prev and current by one
			prev = current;
			current = temp;
		}
		// set head node with prev
		head = prev;
	}

	public void reverseRecursive() {
		Node prev = null;
		// Node current = head;
		reverseRec(prev, head);
	}

	private void reverseRec(Node prev, Node current) {
		if (null == current) {
			head = prev;
			return;
		}
		Node temp = current.getNext();
		current.setNext(prev);
		reverseRec(current, temp);
	}

	public boolean isLinkedListEvenLength() {
		Node temp = head;
		while (temp != null && temp.getNext() != null) {
			temp = temp.getNext().getNext();
		}
		if (temp == null)
			return true;
		else
			return false;
	}

	public void printReverse() {
		printRec(head);
	}

	private void printRec(Node head) {
		if (null == head)
			return;
		else {
			//Node temp=head;
		printRec(head.getNext());
		System.out.print(" " + head.getData());
		}
	}


	// Finding the middle element
	public Node getMiddle() {
		if (head == null) {
			return head;
		}
		Node slow, fast;
		slow = fast = head;
		while (fast!= null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return slow;
	}
	
public void reversek(int k) {
	
	head = reversek(head,k);
}
	
 private  Node reversek(Node head, int k) { 
       Node current = head; 
       Node next = null; 
       Node prev = null; 
         
       int count = 0; 
  
       // Reverse first k nodes of linked list 
       while (count < k && current != null)  { 
           next = current.getNext(); 
           current.setNext(prev);
           prev = current; 
           current = next; 
           count++; 
       } 
       
       /* next is now a pointer to (k+1)th node  
          Recursively call for the list starting from current. 
          And make rest of the list as next of first node */
       if (next != null)  
          head.setNext(reversek(next, k)); 
  
       // prev is now head of input list 
       return prev; 
    }
 
 public void reverseAltk(int k) {
	 head = reverseAltK(head,k);
	 
 }

private Node reverseAltK(Node head, int k) {
	// TODO Auto-generated method stub
	Node current = head; 
    Node next = null, prev = null; 
    int count = 0; 

    /*1) reverse first k nodes of the linked list */
    while (current != null && count < k) { 
        next = current.getNext(); 
        current.setNext(prev); 
        prev = current; 
        current = next; 
        count++; 
    } 

    /* 2) Now head points to the kth node.  So change next  
     of head to (k+1)th node*/
    if (head  != null) { 
        head.setNext(current); 
    } 

    /* 3) We do not want to reverse next k nodes. So move the current  
     pointer to skip next k nodes */
    count = 0; 
    while (count < k - 1 && current != null) { 
        current = current.getNext(); 
        count++; 
    } 

    /* 4) Recursively call for the list starting from current->next. 
     And make rest of the list as next of first node */
    if (current != null) { 
        current.setNext(reverseAltK(current.getNext(), k)); 
    } 

    /* 5) prev is new head of the input list */
    return prev; 

}

public void reverseKAlt(int k) {
	
	reverseKAlt(head, k);
}

private void reverseKAlt(Node head, int k) {
	// TODO Auto-generated method stub
	Node current = head; 
    Node next = null, prev = null; 
    Node prev2=null;
    int count = 0; 
    
    // keep first K items ad is
    while (count < k && current != null) { 
    	prev2 = current;
        current = current.getNext(); 
        count++; 
    }
    
    head = current;
    count = 0;
    // reverse next k items
    while (current != null && count < k) { 
        next = current.getNext(); 
        current.setNext(prev); 
        prev = current; 
        current = next; 
        count++; 
    } 
    
    // link required nodes
    prev2.setNext(prev);
    if(head != null)
    	head.setNext(current); 
    
    // continue till the end 
    if (current != null) { 
    	reverseKAlt(current, k);
    } 
    

}



}
