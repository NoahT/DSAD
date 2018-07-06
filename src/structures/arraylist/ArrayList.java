package structures.arraylist;

import java.util.Arrays;
import java.util.Iterator;

import structures.List;

/**
 * ArrayList data structure
 * containing basic operations for
 * insertion, removal, and retrieval.
 * @author Noah Teshima
 */
public class ArrayList<T> implements List<T> {
	
	/**
	 * Private inner class used to iterate
	 * over elements in the instance's list.
	 * @author Noah Teshima
	 */
	private class ArrayIterator implements Iterator<T> {
		private int index;
		
		/**
		 * Default constructor used to
		 * create an iterator at the beginning
		 * of the list.
		 * @throws IndexOutOfBoundsException if the
		 * given index is out of range (0, size],
		 * where size is the number of elements
		 * stored.
		 */
		public ArrayIterator() throws IndexOutOfBoundsException {
			this(0);
		}
		
		/**
		 * Constructor used to create an iterator
		 * starting at the specified index.
		 * @param index integer value containing
		 * the starting index for the iterator.
		 * @throws IndexOutOfBoundsException if the
		 * given index is out of range (0, size],
		 * where size is the number of elements
		 * stored.
		 */
		public ArrayIterator(int index) throws IndexOutOfBoundsException {
			if(index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			this.index = index;
		}
		
		/**
		 * Method designed to determine whether
		 * there is another element to iterate
		 * over.
		 * @return boolean value determining whether
		 * another element can be iterated over.
		 */
		@Override
		public boolean hasNext() {
			return this.index < (list.length - 1);
		}

		/**
		 * Method designed to iterate over the
		 * next element in the list, while returning
		 * the previous element.
		 * @return Generic type object containing the
		 * previous element iterated over.
		 */
		@Override
		public T next() {
			T returnElement = list[this.index];
			this.skipIndex();
			
			return returnElement;
		}
		
		/**
		 * Private method designed to skip the index
		 * to the next valid element.
		 */
		private void skipIndex() {
			this.index++;
			if(this.hasNext()
					&& list[this.index] == null) {
				this.skipIndex();
			}
		}
		
	}
	
	private static final int DEFAULT_CAPACITY = 10;
	private T[] list;
	private int size;
	
	/**
	 * Default constructor. When invoked, the
	 * initial capacity is set to a default of
	 * 10.
	 */
	public ArrayList() {
		this(ArrayList.DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor used to set the initial
	 * capacity of the ArrayList
	 * @param capacity integer value containing
	 * the initial capacity of the list.
	 */
	public ArrayList(int capacity) {
		this.setCapacity(capacity);
		this.size = 0;
	}
	
	/**
	 * Private mutator method designed to
	 * set the initial capacity of the array
	 * @param capacity integer value containing
	 * the initial capacity of the list.
	 */
	private void setCapacity(int capacity) {
		if(capacity <= 0) {
			capacity = ArrayList.DEFAULT_CAPACITY;
		}
		this.list = (T[]) new Object[capacity];
	}
	
	/**
	 * Private mutator method designed to reallocate
	 * the current list.
	 */
	private void reallocate() {
		this.list = Arrays.copyOf(this.list, this.list.length * 2);
	}
	
	/**
	 * Method designed to add the
	 * specified element to the end of
	 * the list.
	 * @param element Generic type reference
	 * containing the element to add.
	 */
	@Override
	public void add(T element) {
		//reallocate if no more space
		if(this.size == this.list.length) {
			this.reallocate();
		}
		this.add(this.size++, element);
	}

	/**
	 * Method designed to add the
	 * element at the specified index.
	 * @param index integer value containing
	 * the index at which to add the element.
	 * @param element Generic type reference
	 * containing the element to add
	 * @throws IndexOutOfBoundsException if the
	 * given index is not in range [0, capacity)
	 */
	@Override
	public void add(int index, T element) throws IndexOutOfBoundsException {
		//if not in range
		if(index < 0 || index >= this.list.length) {
			throw new IndexOutOfBoundsException();
		}
		//reallocate if necessary
		if(this.size == this.list.length) {
			this.reallocate();
		}
		//only shift if element is at index
		if(this.list[index] != null) {
			for(int backIndex = this.list.length - 1; backIndex > index; backIndex--) {
				this.list[backIndex] = this.list[backIndex - 1];
			}
		}
		this.list[index] = element;
	}

	/**
	 * Method designed to clear all elements
	 * from the current list.
	 */
	@Override
	public void clear() {
		this.list = (T[]) new Object[this.list.length];
	}

	/**
	 * Method designed to check whether the
	 * given reference is equal in value to any
	 * element in the array.
	 * @param object Object reference to check
	 * to be equal in value
	 * @return boolean value determining whether
	 * the given reference is equal in value to
	 * any element in the array
	 */
	@Override
	public boolean contains(Object object) {
		for(T element : this.list) {
			if(object.equals(element)) {
				//TODO implement iterator & use this
				return true;
			}
		}
		return false;
	}

	/**
	 * Method designed to get the first element
	 * inside of the list.
	 * @return Generic type containing the first
	 * element inside of the list.
	 */
	@Override
	public T get() throws IndexOutOfBoundsException {
		return this.get(0);
	}

	/**
	 * Method designed to get the element
	 * at the specified index.
	 * @param index integer value containing
	 * the index at which to retrieve the element
	 * @return Generic type containing the element
	 * at the given index inside of the list.
	 * @throws IndexOutOfBoundsException if the 
	 * index is not in range [0, size)
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		return this.list[index];
	}

	/**
	 * Method designed to retrieve the
	 * index of the first element equal
	 * in value to the given reference.
	 * @param object Object reference
	 * used to check to be equal in value
	 * @return integer value containing the
	 * first index of the element equal in
	 * value to the given reference.
	 */
	@Override
	public int indexOf(Object object) {
		for(int index = 0; index < this.size; index++) {
			if(object.equals(this.list[index])) {
				return index;
			}
		}
		//if not found
		return -1;
	}

	/**
	 * Method designed to check whether
	 * the list has any elements.
	 * @return boolean value determining
	 * whether the list is empty.
	 */
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	/**
	 * Method designed to instantiate
	 * and return a new Iterator object
	 * for iterating over each element
	 * in the current list.
	 * @return Iterator object with basetype
	 * T
	 */
	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}

	@Override
	public T remove() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(T element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
