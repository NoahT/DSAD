package structures;

import java.util.Iterator;

/**
 * Mock List interface used for
 * implementing some of the most
 * commonly used methods in List
 * data structures.
 * @author Noah Teshima
 *
 * @param <T> Generic type containing
 * the data being stored inside of the
 * list.
 */
public interface List<T> extends Iterable<T> {
	/**
	 * Abstract method used to add
	 * the given element at the end of the
	 * current list.
	 * @param element Generic type reference
	 * containing the element to add.
	 */
	public void add(T element);
	
	/**
	 * Abstract method used to add
	 * the given element at the specified
	 * index.
	 * @param index integer value containing
	 * the index to add the element at.
	 * @param element Generic type reference
	 * containing the element to add.
	 * @throws IndexOutOfBoundsException if
	 * the given index is greater than or
	 * equal to the capacity.
	 */
	public void add(int index, T element)
	throws IndexOutOfBoundsException;
	
	/**
	 * Abstract method used to clear all
	 * elements from the current list.
	 */
	public void clear();
	
	/**
	 * Abstract method used to determine
	 * whether the given reference is
	 * found to be equal in value to
	 * any elements currently in the list.
	 * @param object Object reference to
	 * check to be equal in value with
	 * any elements stored inside of the
	 * list.
	 * @return boolean value determining
	 * whether the given reference is
	 * found to be equal in value to any
	 * elements currently in the list.
	 */
	public boolean contains(Object object);
	
	/**
	 * Abstract method used to get the
	 * element at the beginning of the
	 * list without removing it from
	 * the list.
	 * @return Shallow copy of a generic
	 * type T containing the first element
	 * in the list.
	 */
	public T get();
	
	/**
	 * Abstract method used to get
	 * the element at the given index
	 * inside of the list.
	 * @param index
	 * @return Shallow copy of a generic type
	 * T containing the element at the given
	 * index.
	 * @throws IndexOutOfBoundsException
	 * if the given index is out of bounds
	 * for the list.
	 */
	public T get(int index)
	throws IndexOutOfBoundsException;
	
	/**
	 * Abstract method used to get the index
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
	public int indexOf(Object object);
	
	/**
	 * Abstract method used to get whether the
	 * list is empty.
	 * @return boolean value determining whether
	 * the current list is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Abstract method used to get an Iterator
	 * object with base type T to iterate over
	 * the list.
	 * @return Iterator object with base type T.
	 */
	public Iterator<T> iterator();
	
	/**
	 * Abstract method used to remove the element
	 * at the end of the list.
	 * @return Shallow copy of a generic type
	 * T containing the element removed at the end of
	 * the list.
	 * @throws IndexOutOfBoundsException if the array
	 * is empty.
	 */
	public T remove()
	throws IndexOutOfBoundsException;
	
	/**
	 * Abstract method used to remove the element at
	 * the given index.
	 * @param index integer value containing the index
	 * of the element to remove.
	 * @return Shallow copy of a generic type T containing
	 * the element removed at the given index.
	 * @throws IndexOutOfBoundsException
	 * if the given index is out of bounds
	 * for the list.
	 */
	public T remove(int index)
	throws IndexOutOfBoundsException;
	
	/**
	 * Abstract method used to set the element at the
	 * end of the list with the given element.
	 * @param element Generic type reference containing
	 * the element to set at the end of the list.
	 * @return Shallow copy of a generic type T containing
	 * the element formerly at the end of the list.
	 * @throws IndexOutOfBoundsException if the list is
	 * empty.
	 */
	public T set(T element)
	throws IndexOutOfBoundsException;
	
	/**
	 * Abstract method used to set the element at the
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
	public T set(int index, T element)
	throws IndexOutOfBoundsException;
	
	/**
	 * Abstract method used to get the size of the list.
	 * @return integer value containing the size of the
	 * list.
	 */
	public int size();
}

