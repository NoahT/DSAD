package structures.singly_linked_list;

import java.util.Iterator;

import structures.List;

/**
 * Singly linked list data structure
 * containing basic operations for
 * insertion, removal, and retrieval.
 * @author Noah Teshima
 */
public class SinglyLinkedList<T> implements List<T> {
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
	 * Method designed to add the given element
	 * to the beginning of the linked list.
	 * @param element Generic reference type T
	 * to add to the beginning of the linked list.
	 */
	@Override
	public void add(T element) {
		this.add(0, element);
	}
	
	/**
	 * Method designed to add the given element
	 * to the back of the linked list.
	 * @param element Generic reference type T
	 * to add to the end of the linked list.
	 */
	public void addToBack(T element) {
		this.add(this.size, element);
	}
	
	/**
	 * Mutator method used to add the given
	 * node at the specified index.
	 * @param index integer value containing
	 * the location to add the node.
	 * @param data Generic type reference to add to
	 * the linked list.
	 * @throws IndexOutOfBoundsException if the given
	 * index is out of range [0, size]
	 */
	@Override
	public void add(int index, T data) throws IndexOutOfBoundsException {
		Node<T> node = new Node<>(data);
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> pointer = null;
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
	 * Mutator method designed to clear the entire linked list.
	 */
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * Accessor method used to determine whether the
	 * given reference is found to be equal in value to
	 * any elements currently in the list.
	 * @param object Object reference to check to be
	 * equal in value with any elements stored inside
	 * of the list.
	 * @return boolean value determining whether the
	 * given reference is found to be equal in value to
	 * any elements currently in the list.
	 */
	@Override
	public boolean contains(Object object) {
		for(T data : this) {
			if(object.equals(data)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Accessor method used to get an
	 * element from the list.
	 * @return Shallow copy of a generic
	 * type T containing the first element
	 * in the list.
	 * @throws IndexOutOfBoundsException
	 * if the given index is out of bounds
	 * for the list.
	 */
	@Override
	public T get() throws IndexOutOfBoundsException {
		return this.get(0);
	}
	
	/**
	 * Accessor method used to get an
	 * element from the back of the list.
	 * @return Shallow copy of a generic
	 * type T containing the last element
	 * in the list.
	 * @throws IndexOutOfBoundsException
	 * if the given index is out of bounds
	 * for the list.
	 */
	public T getFromBack() throws IndexOutOfBoundsException {
		return this.get(this.size - 1);
	}
	
	/**
	 * Accessor method used to get
	 * the element at the given index
	 * inside of the list.
	 * @param index integer value containing the
	 * index of the element to return.
	 * @return Shallow copy of a generic type
	 * T containing the element at the given
	 * index.
	 * @throws IndexOutOfBoundsException
	 * if the given index is out of bounds
	 * for the list.
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> pointer = null;
		T returnData = null;
		for(int index2 = 0; index2 < index; index2++) {
			pointer = (pointer == null)
					? this.head : pointer.next;
		}
		if(pointer == null) {
			returnData = this.head.data;
		}else {
			returnData = pointer.next.data;
		}
		
		return returnData;
	}
	
	/**
	 * Accessor method used to get the index
	 * of the first object equal in value to
	 * the given method.
	 * @param object Object reference to check
	 * to be equal in value to elements inside
	 * of the list.
	 * @return integer value containing the index
	 * of the first element equal in value to the
	 * given reference. If no elements are equal
	 * in value or the list is empty, -1 is returned.
	 */
	@Override
	public int indexOf(Object object) {
		int index = 0;
		for(T data : this) {
			if(object.equals(data)) {
				return index;
			}
			index++;
		}
		return -1;
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
	 * Accessor method used to get whether the
	 * list is empty.
	 * @return boolean value determining whether
	 * the current list is empty.
	 */
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	/**
	 * Mutator method used to remove an element from
	 * the front of the list.
	 * @return Shallow copy of a generic type T containing
	 * the element removed at the front of the list.
	 * @throws IndexOutOfBoundsException
	 * if the list is empty.
	 */
	@Override
	public T remove() throws IndexOutOfBoundsException {
		return this.remove(0);
	}
	
	/**
	 * Mutator method designed to remove the
	 * last node from the list.
	 * @return Generic reference type T containing the
	 * data of the removed node.
	 * @throws IndexOutOfBoundsException if there
	 * are no nodes in the list.
	 */
	public T removeFromBack() throws IndexOutOfBoundsException {
		return this.remove(size - 1);
	}
	
	/**
	 * Mutator method designed to remove the node at
	 * the given index from the linked list.
	 * @param index integer value containing
	 * the index to remove
	 * @return Generic reference type T containing the
	 * data of the removed node.
	 * @throws IndexOutOfBoundsException if the
	 * given index is out of range [0, size)
	 */
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> pointer = null;
		T returnData = null;
		
		for(int index2 = 0; index2 < index; index2++) {
			pointer = (pointer == null)
					? this.head : pointer.next;
		}
		//index 0, so remove current head
		if(pointer == null) {
			returnData = this.head.data;
			this.head = this.head.next;
		}else {
			returnData = pointer.next.data;
			pointer.next = pointer.next.next;
		}
		this.size--;
		
		return returnData;
	}
	
	/**
	 * Abstract method used to set the element at the
	 * beginning of the list with the given element.
	 * @param element Generic type reference containing
	 * the element to set at the end of the list.
	 * @return Shallow copy of a generic type T containing
	 * the element formerly at the end of the list.
	 * @throws IndexOutOfBoundsException if the given index
	 * is out of bounds for the list.
	 */
	@Override
	public T set(T element) throws IndexOutOfBoundsException {
		return this.set(0, element);
	}
	
	/**
	 * Mutator method used to set the element at the
	 * given index with the given element.
	 * @param index integer value containing the index
	 * of the element to replace.
	 * @param element Generic type reference containing
	 * the element to set at the end of the list.
	 * @return Shallow copy of a generic type T containing
	 * the element formerly at the end of the list.
	 * @throws IndexOutOfBoundsException if the given index
	 * is out of bounds for the list.
	 */
	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException {
		Node<T> node = new Node<>(element, this.head.next);
		T returnData = this.head.data;
		this.head = node;
		
		return returnData;
	}
	
	/**
	 * Accessor method used to get the
	 * size of the linked list.
	 * @return integer value containing
	 * the size of the linked list.
	 */
	@Override
	public int size() {
		return this.size;
	}
	
	/**
	 * Accessor method used to get the
	 * list as an Array.
	 * @return Array of basetype T, where
	 * each element is a shallow copy.
	 */
	@Override
	public T[] toArray() {
		T[] returnArray = (T[]) new Object[this.size];
		
		for(int index = 0; index < this.size; index++) {
			returnArray[index] = this.get(index);
		}
		
		return returnArray;
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

