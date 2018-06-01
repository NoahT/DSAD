package structures.singly_linked_list;

import java.util.Iterator;

/**
 * Singly linked list data structure
 * containing basic operations for
 * insertion, removal, and retrieval.
 * @author Noah Teshima
 */
public class SinglyLinkedList<T> implements Iterable<T> {
	/**
	 * Private inner class designed
	 * to hold data and a link to each
	 * node.
	 * @author Noah Teshima
	 * @param <E> generic type parameter
	 * used for encapsulated data
	 */
	private class Node<E> {
		private E data;
		private Node<E> next;
		
		/**
		 * Default constructor used
		 * to set the instance's data
		 * and link field to null
		 */
		public Node() {
			this(null, null);
		}
		
		/**
		 * Constructor used to set the
		 * encapulsated data without a
		 * link to another node.
		 * @param data Generic type
		 * used to hold the instance's
		 * data.
		 */
		public Node(E data) {
			this(data, null);
		}
		
		/**
		 * Constructor used to set the
		 * instance's data and link to
		 * the given values.
		 * @param data Generic type used
		 * to hold the instance's data
		 * @param next Node reference containing
		 * the next Node in the list
		 */
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		/**
		 * Accessor method used to get
		 * the node's data.
		 * @return Object of parameterized type
		 * containing the node's data.
		 */
		public E getData() {
			return (E) this.data;
		}
		
		/**
		 * Overridden method from Object class.
		 * Used to check if the given Node is
		 * equal in value to the current node.
		 * @param obj Object reference with
		 * actual type Node
		 * @return boolean value determining
		 * if the current node and the
		 * given node are equal in value
		 */
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Node)) {
				return false;
			}
			Node<?> nodeObj = (Node<?>) obj;
			return (this.data.equals(nodeObj.getData()));
		}
		
		/**
		 * Overridden method from Object class.
		 * Used to get information about the
		 * current node's data.
		 * @return String object containing information
		 * about the node's data.
		 */
		@Override
		public String toString() {
			return String.format("%s\n"
					+ "Has link: %b",
					this.data,
					(this.next != null));
		}
	}
	
	/**
	 * Private inner class designed to
	 * iterate through a singly linked
	 * list.
	 * @author Noah Teshima
	 *
	 */
	private class LinkedIterator implements Iterator<T> {
		private Node<T> pointer;
		
		/**
		 * Default constructor used
		 * to place a pointer at
		 * the head of the linked list.
		 */
		public LinkedIterator() {
			this(0);
		}
		
		/**
		 * Constructor used to set the
		 * pointer of the iterator at the
		 * specified index.
		 * @param index integer value containing
		 * the location of the pointer
		 * @throws IndexOutOfBoundsException if the
		 * given index is out of range (0, size],
		 * where size is the number of nodes
		 */
		public LinkedIterator(int index) throws IndexOutOfBoundsException {
			if(index < 0 || index > size) {
				throw new IndexOutOfBoundsException();
			}
			this.pointer = head;
			for(int index2 = 0; index2 < index; index2++) {
				this.next();
			}
		}
		
		/**
		 * Overridden method stub from Iterable
		 * interface. Determines whether there
		 * is a link to the next node in the
		 * list.
		 * @return boolean value determining
		 * whether there is a link to the next
		 * node.
		 */
		@Override
		public boolean hasNext() {
			return (this.pointer != null);
		}
		
		/**
		 * Accessor method designed to move the
		 * pointer to the next node.
		 * @return Parameterized object containing
		 * the data of the node iterated over.
		 */
		@Override
		public T next() {
			T returnData = this.pointer.data;
			this.pointer = this.pointer.next;
			
			return returnData;
		}
		
		/**
		 * Overridden method stub from Iterable
		 * interface. Used to remove the node
		 * immediately front of the pointer.
		 */
		@Override
		public void remove() {
			if(this.hasNext()) {
				this.pointer.next = this.pointer.next.next;
			}
		}
	}
	
	private Node<T> head;
	private int size;
	
	/**
	 * Default constructor used to
	 * set the head node to null
	 * and the size to 0.
	 */
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * Constructor used to set the head node
	 * of a linked list.
	 * @param data Generic type reference used for
	 * the head node of the instance's linked list.
	 */
	public SinglyLinkedList(T data) {
		Node<T> node = new Node<>(data);
		this.head = node;
		this.size = 1;
	}
	
	/**
	 * Accessor method used to get the
	 * size of the linked list.
	 * @return integer value containing
	 * the size of the linked list.
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Mutator method used to add the given
	 * node at the specified index.
	 * @param data Generic type reference to add to
	 * the linked list.
	 * @param index integer value containing
	 * the location to add the node.
	 * @throws IndexOutOfBoundsException if the given
	 * index is out of range [0, index]
	 */
	public void add(T data, int index) throws IndexOutOfBoundsException {
		Node<T> node = new Node<>(data);
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> pointer = null;//this.head;
		for(int index2 = 0; index2 < index; index2++) {
			pointer = (pointer == null)
					? this.head : pointer.next;
		}
		
		//list is empty, so add to front
		if(pointer == null) {
			node.next = this.head;
			this.head = node;
		}else {
			node.next = pointer.next;
			pointer.next = node;
		}
		
		this.size++;
	}
	
	/**
	 * Mutator method designed to add
	 * the given node to the front of
	 * the linked list.
	 * @param node Node reference containing
	 * the node to add to the front of the
	 * list.
	 * @throws IndexOutOfBoundsException if the given
	 * index is out of range [0, index]
	 */
	public void addToFront(T data) throws IndexOutOfBoundsException {
		this.add(data, 0);
	}
	
	/**
	 * Mutator method designed to add the
	 * given node to the back of the
	 * linked list.
	 * @param data Generic type reference for
	 * the node to add to the back of the
	 * list.
	 * @throws IndexOutOfBoundsException if the given
	 * index is out of range [0, size]
	 */
	public void addToBack(T data) throws IndexOutOfBoundsException {
		this.add(data, this.size);
	}
	
	/**
	 * Mutator method designed to remove the node at
	 * the given index from the linked list.
	 * @param index integer value containing
	 * the index to remove
	 * @throws IndexOutOfBoundsException if the
	 * given index is out of range [0, size)
	 */
	public void remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> pointer = null;
		
		for(int index2 = 0; index2 < index; index2++) {
			pointer = (pointer == null)
					? this.head : pointer.next;
		}
		//index 0, so remove current head
		if(pointer == null) {
			this.head = this.head.next;
		}else {
			pointer.next = pointer.next.next;
		}
		
		this.size--;
	}
	
	/**
	 * Mutator method designed to remove the head
	 * node from the list.
	 * @throws IndexOutOfBoundsException if there
	 * are no nodes in the list.
	 */
	public void removeFromFront() throws IndexOutOfBoundsException {
		this.remove(0);
	}
	
	/**
	 * Mutator method designed to remove the
	 * last node from the list.
	 * @throws IndexOutOfBoundsException if there
	 * are no nodes in the list.
	 */
	public void removeFromBack() throws IndexOutOfBoundsException {
		this.remove(size - 1);
	}
	
	/**
	 * Mutator method designed to clear the entire linked list.
	 */
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Accessor method designed to get a
	 * LinkedIterator object at the
	 * specified index
	 * @param index integer value containing
	 * the location to start iterating
	 * @return Iterator object with actual type
	 * LinkedIterator.
	 */
	@Override
	public Iterator<T> iterator() {
		return new LinkedIterator();
	}
	
	/**
	 * Overridden method from Object class.
	 * Used to get a String object containing 
	 * information about each node in the linked
	 * list.
	 * @return String object containing information
	 * about each node in the linked list.
	 */
	@Override
	public String toString() {
		String returnString = "";
		for(T data : this) {
			returnString += data + "\n";
		}
		
		returnString += String.format("Size: %d",
				this.size);
		
		return returnString;
	}
}
