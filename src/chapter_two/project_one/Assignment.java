package chapter_two.project_one;

import java.util.Date;

/**
 * Aggregate class designed to hold
 * a single assignment's due date
 * and description
 * @author Noah Teshima
 *
 */
class Assignment implements Comparable<Assignment>, Cloneable {
	private Date date;
	private String assignment;
	
	/**
	 * Copy constructor used to make a deep copy
	 * based on the given reference.
	 * @param assignment Assignment reference
	 * used to make a deep copy for the current
	 * instance.
	 */
	public Assignment(Assignment assignment) {
		this(assignment.getAssignment(), assignment.getDate());
	}
	
	/**
	 * Default constructor used to set the instance's
	 * due date and assignment.
	 * @param assignment String reference containing a
	 * description of the current assignment.
	 * @param date Date reference containing the due
	 * date of the assignment.
	 */
	public Assignment(String assignment, Date date) {
		this.setAssignment(assignment);
		this.setDate(date);
	}
	
	/**
	 * Private mutator method designed to set the assignment
	 * description
	 * @param assignment String reference containing
	 * the new assignment description.
	 */
	private void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	
	/**
	 * Accessor method used to get the assignment.
	 * @return String object containing the 
	 * assignment description.
	 */
	public String getAssignment() {
		return this.assignment;
	}
	
	/**
	 * Private mutator method designed to set the
	 * due date.
	 * @param date Date reference containing the
	 * due date.
	 */
	private void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Accessor method used to get the due date
	 * for the current assignment.
	 * @return Date object containing the due date.
	 */
	public Date getDate() {
		return (Date) this.date.clone();
	}
	
	/**
	 * Accessor method designed to get whether the
	 * current assignement is past due.
	 * @return boolean value determining whether the
	 * current assignment is past due.
	 */
	public boolean pastDue() {
		return this.date.getTime() < System.currentTimeMillis();
	}
	
	/**
	 * Overridden method stub from Cloneable interface.
	 * Used to get a deep copy of the current instance.
	 * @return Assignment object serving as a deep copy
	 * of the current instance.
	 */
	@Override
	public Object clone() {
		try {
			Assignment assignment = (Assignment) super.clone();
			assignment.setDate((Date) this.date.clone());
			return assignment;
		}catch(CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Overridden method from Comparable. Used
	 * to compare the current instance and the
	 * given reference by their due dates.
	 * @param obj Assignment reference containing the
	 * assignment object to compare.
	 * @return integer value determining the order
	 * of due dates. If the current instance has a
	 * due date earlier than the given reference,
	 * -1 is returned. If the current instance has
	 * a due date later than the given reference,
	 * 1 is returned. Otherwise 0 is returned.
	 */
	@Override
	public int compareTo(Assignment obj) {
		return this.date.compareTo(obj.getDate());
	}
	
	/**
	 * Overridden method from Object class.
	 * Used to see if the current instance and
	 * the given reference are equal in due date
	 * and assignment descriptions.
	 * @param obj Object reference with actual
	 * type Assignment
	 * @return boolean value determining whether
	 * the current instance and the given reference
	 * have the same due date and assignment
	 * descriptions.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Assignment)) {
			return false;
		}
		Assignment assignmentObj = (Assignment) obj;
		
		return(this.date.equals(assignmentObj.getDate())
				&& this.assignment.equals(assignmentObj.getAssignment()));
	}
	
	/**
	 * Overridden method from Object class.
	 * Used to get the instance's assignment
	 * description and due date as a String
	 * object.
	 * @return String object containing the
	 * instance's assignment description and
	 * due date.
	 */
	@Override
	public String toString() {
		return String.format("[%s] %s\n",
				this.date,
				this.assignment);
	}
}

