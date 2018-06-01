package chapter_two.project_one;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Assignment list implementation with
 * the Collections framework doubly linked list.
 * @author Noah Teshima
 *
 */
public class HomeworkList {
	private LinkedList<Assignment> list;
	private int size;
	
	/**
	 * Default constructor used to
	 * instantiate an empty linked list
	 * for assignments.
	 */
	public HomeworkList() {
		this.list = new LinkedList<>();
		this.size = 0;
	}
	
	/**
	 * Mutator method designed to add a new
	 * assignment by due date.
	 * @param assignment Assignment reference
	 * to add to the current list.
	 */
	public void add(Assignment assignment) {
		ListIterator<Assignment> iterator = this.list.listIterator();
		while(iterator.hasNext()) {
			if(assignment.compareTo(iterator.next()) < 0) {
				iterator.previous();
				iterator.add(assignment);
				this.size++;
				return;
			}
		}
		iterator.add(assignment);
		this.size++;
	}
	
	/**
	 * Mutator method designed to remove the
	 * first assignment from the list equal
	 * to the given assignment.
	 * @param assignment Assignment reference
	 * to remove from the list if equal in value
	 * to any of the current assignments.
	 */
	public void remove(Assignment assignment) {
		Iterator<Assignment> iterator = this.list.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(assignment)) {
				iterator.remove();
				this.size--;
			}
		}
	}
	
	/**
	 * Accessor method used to get the 
	 * earliest assignment.
	 * @return Assignment object containing a deep
	 * copy of the first assignment. If the list is
	 * empty, null is returned.
	 */
	public Assignment getEarliestAssignment() {
		return (this.size > 0) ? this.list.getFirst() : null;
	}
	
	/**
	 * Accessor method designed to get the size of the
	 * list.
	 * @return integer value containing the size of the
	 * list.
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Overridden method from Object class.
	 * When invoked, each Assignment is checked
	 * to be equal in value.
	 * @param obj Object reference with actual
	 * type HomeworkList
	 * @return boolean value determining whether
	 * each assignment is equal in value.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof HomeworkList)) {
			return false;
		}
		HomeworkList listObj = (HomeworkList) obj;
		
		return (this.size == listObj.getSize());
	}
	
	/**
	 * Overridden method from Object class.
	 * Used to get information about each assignment
	 * and the total number of assignments.
	 * @return String object containing information about
	 * each assignment and the total number of assignments.
	 */
	@Override
	public String toString() {
		return String.format("%s\n"
				+ "Size: %d",
				this.list,
				this.size);
	}
}
