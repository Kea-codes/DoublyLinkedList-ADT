
public class Node<T> {
	private T element;
	Node<T> next;
	Node<T> prev;

	/**
	 * Constructs a node with the given element, next, and previous nodes.
	 * 
	 * @param element The data stored in the node.
	 * @param next    The next node in the list.
	 * @param prev    The previous node in the list.
	 */
	public Node( Node<T> next, Node<T> prev, T element) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	public Node(T item) {
		// TODO Auto-generated constructor stub
		this.element=item;
	}

	/**
	 * Returns the element stored in the node.
	 * 
	 * @return The element.
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Returns the next node.
	 * 
	 * @return The next node.
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Sets the next node.
	 * 
	 * @param next The next node.
	 */
	public void setNext(Node<T> next) {

		this.next = next;
	}

	/**
	 * Returns the previous node.
	 * 
	 * @return The previous node.
	 */
	public Node<T> getPrev() {
		return prev;
	}

	/**
	 * Sets the previous node.
	 * 
	 * @param prev The previous node.
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "<" + element + ">";
	}
}