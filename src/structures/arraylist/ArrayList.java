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
		this.list[this.size++] = element;
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

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
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
