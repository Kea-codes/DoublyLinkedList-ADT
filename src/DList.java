
public class DList<T extends Comparable<T>> implements IList<T>, Cloneable {

	private Node<T> header = null;
	private Node<T> trailer = null;
	private Integer size = 0;

	/**
	 * Default constructor
	 */
	public DList() {
		trailer = new Node<T>(null, null, null);
		header = new Node<T>(trailer, null, null);
		trailer.setPrev(header);
		size = 0;
	}

	/**
	 * Construct a List from an Array
	 * 
	 * @param fromArray the array used to construct the list
	 */
	public DList(T[] fromArray) {
		// COMPLETE CODE HERE

		this(); // Call the default constructor
		for (T item : fromArray) {
			addLast(item);
		}
	}

	/**
	 * Convert the list to an array.
	 */
	public T[] toArray() {
		// COMPLETE CODE HERE

		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		Node<T> current = header.getNext();
		for (int i = 0; i < size; i++) {
			array[i] = current.getElement();
			current = current.getNext();
		}
		return array;
	}

	/**
	 * Provide a deep copy of the Linked List
	 */
	@Override
	public DList<T> clone() {
		// COMPLETE CODE HERE

		DList<T> newList = new DList<>();
		Node<T> current = header.getNext();
		while (current != trailer) {
			newList.addLast(current.getElement());
			current = current.getNext();

		}
		return newList;

	}

	/**
	 * Add an element after a given node in the list
	 */
	@Override
	public Node<T> addAfter(Node<T> elem, T item) {
		// COMPLETE CODE HERE
		
		Node<T> newNode = new Node<T>(elem, elem.getNext(), item);
		elem.getNext().setPrev(newNode);
		elem.setNext(newNode);
		size++;
		return newNode;
	}

	/**
	 * Add an element before a given node in a list
	 */
	@Override
	public Node<T> addBefore(Node<T> elem, T item) {
		// COMPLETE CODE HERE

		Node<T> new_node = new Node<T>( item);
		new_node.prev = elem.prev;
		new_node.next = elem;
		size++;
		return new_node;
	}

	/**
	 * Add an element to the start of the list
	 */
	public Node<T> addFirst(T item) {
		return addAfter(header, item);
	}

	/**
	 * Add an element to the end of the list
	 */
	public Node<T> addLast(T item) {
		return addBefore(trailer, item);
	}

	/**
	 * Remove a specified node from the list. The removed element is returned
	 */
	@Override
	public T remove(Node<T> elem) {
		// COMPLETE CODE HERE
		if (elem == header || elem == trailer) {
			return null; // Cannot remove header or trailer
		}
		elem.getPrev().setNext(elem.getNext());
		elem.getNext().setPrev(elem.getPrev());
		size--;
		return elem.getElement();
	}

	/**
	 * Returns the node that contains the element that is specified as a parameter
	 */
	@Override
	public Node<T> search(T elem) {
		// COMPLETE CODE HERE

		Node<T> current = header.getNext();
		while (current != trailer) {
			if (current.getElement().equals(elem)) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}

	/**
	 * Returns true if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return (header.getNext() == trailer);
	}

	/**
	 * Return the size of the list
	 */
	@Override
	public Integer size() {
		return size;
	}

	/**
	 * Return the first element in the list
	 */
	public T head() {
		return header.getNext().getElement();
	}

	/**
	 * Returns a list that contains everything except the first element
	 */
	public IList<T> tail() {
		// COMPLETE CODE HERE

		DList<T> newList = new DList<>();
		Node<T> current = header.getNext().getNext();
		while (current != trailer) {
			newList.addLast(current.getElement());
			current = current.getNext();
		}
		return newList;
	}

	@Override
	public String toString() {
		String result = header.toString() + " <-> ";
		Node<T> currentNode = header.getNext();

		// COMPLETE CODE HERE
		while (currentNode != trailer) {
			result += currentNode.getElement() +(" <-> ");

			currentNode = currentNode.getNext();
		}
		result += trailer.toString();
		return result.toString();
		
	}

	/**
	 * Return a new list that contains all the element in the current list that are
	 * less than a specified element
	 */
	public DList<T> splitLess(T element) {
		// COMPLETE CODE HERE

		DList<T> newList = new DList<>();
		Node<T> current = header.getNext();
		while (current != trailer) {
			if (current.getElement().compareTo(element) < 0) {
				newList.addLast(current.getElement());
			}
			current = current.getNext();
		}
		return newList;
	}

	/**
	 * Return a new list that contains all the element in the current list that are
	 * greater than a specified element
	 */
	public DList<T> splitGreater(T element) {
		// COMPLETE CODE HERE

		DList<T> newList = new DList<>();
		Node<T> current = header.getNext();
		while (current != trailer) {
			if (current.getElement().compareTo(element) > 0) {
				newList.addLast(current.getElement());
			}
			current = current.getNext();
		}
		return newList;
	}

	/**
	 * Return a new list that contains all the element in the current list that are
	 * equal to a specified element
	 */
	public DList<T> splitEqual(T element) {
		// COMPLETE CODE HERE

		DList<T> newList = new DList<>();
		Node<T> current = header.getNext();
		while (current != trailer) {
			if (current.getElement().compareTo(element) == 0) {
				newList.addLast(current.getElement());
			}
			current = current.getNext();
		}
		return newList;
	}

	/**
	 * Return a new IList that contains the elements merged from the current list
	 * and the passed otherList
	 * 
	 * @param otherList the other list to merge
	 * @return a new list of element
	 */
	public DList<T> merge(DList<T> otherList) {
		DList<T> newList = new DList<T>();
		Node<T> current1 = header.getNext();
		Node<T> current2 = otherList.header.getNext();

		// COMPLETE CODE HERE

		while (current1 != trailer && current2 != trailer) {
			if (current1.getElement().compareTo(current2.getElement()) <= 0) {
				newList.addLast(current1.getElement());
				current1 = current1.getNext();
			} else {
				newList.addLast(current2.getElement());
				current2 = current2.getNext();
			}
		}
		// Add remaining elements from the current list
		while (current1 != trailer) {
			newList.addLast(current1.getElement());

			current1 = current1.getNext();
		}
		// Add remaining elements from the other list
		while (current2 != trailer) {
			newList.addLast(current2.getElement());
			current2 = current2.getNext();
		}

		return newList;
	}

	/**
	 * Return a new list that has been sorted using a quick sort.
	 * 
	 * @return a sorted list
	 */
	public DList<T> quicksort() {
		if (size() <= 1)
			return this.clone();

		// COMPLETE CODE HERE
		T pivot = head();
		DList<T> smaller = splitLess(pivot);
		DList<T> equal = splitEqual(pivot);
		DList<T> greater = splitGreater(pivot);
		smaller = smaller.quicksort();
		greater = greater.quicksort();
		return smaller.merge(equal).merge(greater);
		// merge everything together
		// DList<T> sortedList = smaller.merge(equal).merge(greater);
		// return sortedList;
	}

}
