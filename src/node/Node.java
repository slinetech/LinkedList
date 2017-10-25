package node;

public class Node<T> {
	private T value = null;
	private Node<T> next = null;
	private Node<T> back = null;
	private long index = 0;

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public Node() {
		this.value = null;
	}

	public Node(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getBack() {
		return back;
	}

	public void setBack(Node<T> back) {
		this.back = back;
	}

	@Override
	public String toString() {
		return this.index + " " + this.value;
	}

}
