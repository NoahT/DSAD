package structures.unit_tests;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import structures.singly_linked_list.SinglyLinkedList;

/**
 * @author Noah Teshima
 * Test suite for SinglyLinkedList class
 */
public class SinglyLinkedListTest {

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void addNullTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		//add only one element
		list.add(null);
		Assertions.assertArrayEquals(new Integer[] {null}, list.toArray());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void addInvalidIndexTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		//add only one element
		list.add(1, 0);
		Assertions.assertArrayEquals(new Integer[] {0}, list.toArray());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void addToBeginningTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		//add only one element
		list.add(0);
		Assertions.assertArrayEquals(new Integer[] {0}, list.toArray());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void addToMiddleTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		//add only one element
		list.add(0);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(2, 2);
		Assertions.assertArrayEquals(new Integer[] {4, 3, 2, 1, 0}, list.toArray());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#add(int, java.lang.Object)}.
	 */
	@Test
	public void addToEndTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		//add only one element
		list.addToBack(4);
		list.addToBack(3);
		list.addToBack(2);
		list.addToBack(1);
		list.addToBack(0);
		Assertions.assertArrayEquals(new Integer[] {4, 3, 2, 1, 0}, list.toArray());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#clear()}.
	 */
	@Test
	public void clearEmptyTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		//clear empty array
		list.clear();
		Assertions.assertArrayEquals(new Integer[] {}, list.toArray());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#clear()}.
	 */
	@Test
	public void clearFilledListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		//clear empty array
		list.clear();
		Assertions.assertArrayEquals(new Integer[] {}, list.toArray());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public void containsFilledListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);

		Assertions.assertTrue(list.contains(1), "Does not contain 1");
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public void containsFalseFilledListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);

		Assertions.assertFalse(list.contains(4), "Should not contain 4");
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#contains(java.lang.Object)}.
	 */
	@Test
	public void containsEmptyListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		Assertions.assertFalse(list.contains(1), "Should not contain 1 in empty list");
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#get(int)}.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void getInvalidTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(0);

		Assertions.assertEquals(null, list.get(2));
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#get(int)}.
	 */
	@Test
	public void getBeginningTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(0);

		Assertions.assertEquals(new Integer(0), list.get(0));
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#get(int)}.
	 */
	@Test
	public void getMiddleTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(0);
		list.add(1);
		list.add(2);

		Assertions.assertEquals(new Integer(1), list.get(1));
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#get(int)}.
	 */
	@Test
	public void getEndTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(0);
		list.add(1);
		list.add(2);

		Assertions.assertEquals(new Integer(0), list.getFromBack());
	}

	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void indexOfEmptyTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		Assertions.assertEquals(-1, list.indexOf(-1));
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void indexOfNotFoundTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(0);
		list.add(1);
		list.add(2);
		
		Assertions.assertEquals(-1, list.indexOf(3));
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void indexOfBeginningTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(4);
		list.add(5);
		list.add(6);
		
		Assertions.assertEquals(0, list.indexOf(6));
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void indexOfMiddleTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(4);
		list.add(5);
		list.add(6);
		
		Assertions.assertEquals(1, list.indexOf(5));
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#indexOf(java.lang.Object)}.
	 */
	@Test
	public void indexOfEndTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(4);
		list.add(5);
		list.addToBack(6);
		
		Assertions.assertEquals(2, list.indexOf(6));
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#isEmpty()}.
	 */
	@Test
	public void isEmptyNotFilledTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		Assertions.assertTrue(list.isEmpty(), "List is not empty");
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#isEmpty()}.
	 */
	@Test
	public void isEmptyFilledTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(0);
		
		Assertions.assertFalse(list.isEmpty(), "List is empty");
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#remove(int)}.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void removeInvalidIndexTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(5);
		list.add(6);
		list.add(7);
		list.remove(3);
		
		Assertions.assertArrayEquals(new Integer[] {5, 6, 7}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#remove(int)}.
	 */
	@Test
	public void removeFromFrontTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(5);
		list.add(6);
		list.add(7);
		list.remove();
		
		Assertions.assertArrayEquals(new Integer[] {6, 5}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#remove(int)}.
	 */
	@Test
	public void removeFromMiddleTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(5);
		list.add(6);
		list.add(7);
		list.remove(1);
		
		Assertions.assertArrayEquals(new Integer[] {7, 5}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#remove(int)}.
	 */
	@Test
	public void removeFromBackTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		list.add(5);
		list.add(6);
		list.add(7);
		list.removeFromBack();
		
		Assertions.assertArrayEquals(new Integer[] {7, 6}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void setEmptyListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.set(1);
		
		Assertions.assertArrayEquals(new Integer[] {1}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public void setBeginningTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(5);
		list.add(6);
		list.add(7);
		
		Assertions.assertEquals(new Integer(7), list.set(1), "Element at zeroth index should be 7");
		Assertions.assertArrayEquals(new Integer[] {1, 6, 5}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public void setMiddleTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(5);
		list.add(6);
		list.add(7);
		
		Assertions.assertEquals(new Integer(6), list.set(1, 1), "Element at first index should be 6");
		Assertions.assertArrayEquals(new Integer[] {7, 1, 5}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#set(int, java.lang.Object)}.
	 */
	@Test
	public void setEndTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(5);
		list.add(6);
		list.add(7);
		
		Assertions.assertEquals(new Integer(5), list.setEnd(1), "Element at last index should be 5");
		Assertions.assertArrayEquals(new Integer[] {7, 6, 1}, list.toArray());
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#size()}.
	 */
	@Test
	public void sizeEmptyTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		Assertions.assertEquals(0, list.size(), "Size should be 0");
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#size()}.
	 */
	@Test
	public void sizeFilledListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(5);
		list.add(6);
		list.add(7);
		
		Assertions.assertEquals(3, list.size(), "Size should be 3");
	}
	
	/**
	 * Test method for {@link structures.singly_linked_list.SinglyLinkedList#size()}.
	 */
	@Test
	public void sizeFilledAndRemovedListTest() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		
		list.add(5);
		list.add(6);
		list.add(7);
		
		list.remove();
		list.removeFromBack();
		
		list.add(8);
		
		Assertions.assertEquals(2, list.size(), "Size should be 2");
	}
}
