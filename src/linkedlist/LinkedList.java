package linkedlist;


import java.util.Iterator;

import node.Node;

public class LinkedList<T> implements Iterator<String>{

	private Node<T> sentinel = null;
	private Node<T> auxIetr=null;
	
	public LinkedList() {
		createList();

	}

	public LinkedList(T value) {
		this();
		Node<T> tmp = new Node<T>(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);
	}

	private void createList() {
		sentinel = new Node<T>();
		sentinel.setIndex(-1);
	}

	public void addBefore(T value) {
		Node<T> tmp = sentinel.getNext();
		Node<T> _new = new Node<T>(value);
		_new.setNext(tmp);
		sentinel.setNext(_new);
		_new.setNext(tmp);
		reIndex();
	}

	public void addBefore(long index,T value) {
		Node<T> tmp = this.sentinel;
		Node<T>_new = new Node<T>(value);
		Node<T> old=null;
		while(tmp.getNext() != null) {
			if (tmp.getNext().getIndex() == index) {
				old.setNext(_new);
				_new.setNext(tmp);
				reIndex();
				break;
			}
			old = tmp;
			tmp=tmp.getNext();
		}
	}
	
	public void addBefore(T value,T newValue) {
		Node<T> tmp = this.sentinel;
		Node<T> _new=new Node<T>(newValue);
		while (tmp.getNext()!=null) {
			if (tmp.getNext().getValue().equals(value)) {
				_new.setNext(tmp.getNext());
				tmp.setNext(_new);
				reIndex();
				break;
			}
			tmp=tmp.getNext();
		}
	}
	
	public void addAfter(T value,T newValue) {
		Node<T> tmp = this.sentinel;
		Node<T> _new=new Node<T>(newValue);
		while (tmp.getNext() != null) {
			if (tmp.getNext().getValue().equals(value)) {
				if (tmp.getNext().getNext() != null) {
					_new.setNext(tmp.getNext().getNext());
					tmp.getNext().setNext(_new);
					break;
				}else {
					
				}
			}
			tmp = tmp.getNext();
		}
		reIndex();
	}
	
	private void reIndex() {
		Node<T> tmp = sentinel;
		int i = 0;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			tmp.setIndex(i++);
		}
	}

	public void printer() {
		printer(sentinel);
	}

	private void printer(Node<T> tmp) {
		if (tmp.getNext() == null) {
			return;
		} else {
			System.out.println("" + tmp.getNext().getValue());
			printer(tmp.getNext());
		}
	}

	public void pronter() {
		Node<T> tmp = sentinel;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			System.out.println(tmp.getIndex() + " " + tmp.getValue());
		}
	}
	
	public void addFirst(T value) {
		if (!isEmpty()) {
			Node<T> _new = new Node<T>(value);
			_new.setNext(sentinel.getNext());
			sentinel.setNext(_new);
			reIndex();
		}
	}
	
	public void addLast(T value) {
		Node<T> tmp = sentinel;
		// Node<T> _new = new Node<T>(value);
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(new Node<T>(value));
		reIndex();
	}

	public void addLast2(T value) {
		Node<T> tmp = sentinel;
		/*
		 * Node<T> niu = new Node<T>(value); if(tmp.getNext()!=null) {
		 * tmp=tmp.getNext(); addLast2(tmp.getValue(), niu); }else { tmp.setNext(niu); }
		 */
		addLast2(value, tmp);
	}

	private void addLast2(T value, Node<T> list) {
		if (list.getNext() == null) {
			list.setNext(new Node<T>(value));
			reIndex();
			return;
		} else {
			addLast2(value, list.getNext());
		}
	}

	public boolean isEmpty() {
		if (this.sentinel.getNext() != null) {
			return false;
		} else {
			return true;
		}
	}

	public String get(long index) {
		Node<T> tmp = this.sentinel;
		if (!isEmpty()) {
			if (index >= 0 && index <= size()) {
				while (tmp.getNext() != null) {
					if (tmp.getNext().getIndex() == index) {
						return tmp.getNext().getValue().toString();
					}
					tmp = tmp.getNext();
				}
			} else {
				return "El index no se encuentra en la lista";
			}
		} else {
			return "La lista esta vacia";
		}
		return "";
	}
	public Node<T> serch(T value){
		return serch(value, this.sentinel);
	}

	private Node<T> serch(T value, Node<T> list) {
		if (!isEmpty()) {
			if (list.getNext()!= null) {
				if (list.getNext().getValue().equals(value)) {
					return list.getNext();
				}else{
					return serch(value, list.getNext());
				}
			}else {
				return null;
			}
		}
		return null;
	}

	public void clear() {
		if (!isEmpty()) {
			this.sentinel = null;
			System.gc();
		}
		createList();
	}

	public int size() {
		Node<T> tmp = this.sentinel;
		int cont = 0;
		while (tmp.getNext() != null) {
			cont++;
			tmp = tmp.getNext();
		}
		return cont;
	}

	public T getFirst() {
		T data = null;
		if (!isEmpty()) {
			data = sentinel.getNext().getValue();
		}
		return data;
	}

	public T getLast() {
		T data = null;
		Node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			data = tmp.getValue();
		}
		return data;
	}

	public void remplace(T oldValue, T newValue) {
		Node<T> tmp = this.sentinel;
		while (tmp.getNext() != null) {
			if (tmp.getNext().getValue() == oldValue) {
				tmp.getNext().setValue(newValue);
			}
			tmp = tmp.getNext();
		}
	}

	public void remplace(long index, T newValue) {
		Node<T> tmp = this.sentinel;
		while (tmp.getNext() != null) {
			if (tmp.getNext().getIndex() == index) {
				tmp.getNext().setValue(newValue);
			}
			tmp = tmp.getNext();
		}
	}

	public void remove(T value) {
		Node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getNext() != null) {
				if (tmp.getNext().getValue().equals(value)) {
					tmp.setNext(tmp.getNext().getNext());
					reIndex();
					break;
				}
				tmp = tmp.getNext();
			}
		}

	}

	public void remove(long index) {
		Node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getNext() != null) {
				if (tmp.getNext().getIndex() == index) {
					tmp.setNext(tmp.getNext().getNext());
					reIndex();
					break;
				}
				tmp = tmp.getNext();
			}
		}
	}

	public void revomeLast() {
		Node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getNext().getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(null);
			System.gc();
			reIndex();
		}
	}

	public void removeFirst() {
		if (!isEmpty()) {
			sentinel.setNext(sentinel.getNext().getNext());
			System.gc();
			reIndex();
		}
	}
	
	public void removeBefore(T value) {
		Node<T> tmp = this.sentinel;
		Node<T> old=null;
		if (!isEmpty()) {
			while(tmp.getNext() != null) {
				if (tmp.getNext().getValue().equals(value)) {
					if (old != null) {
						old.setNext(tmp.getNext());
						System.gc();
						reIndex();
						break;
					}else {
						System.out.println("No se puede eliminar un dato antes de la lista por que el valor" + value + "es el primer elemento de la lista");
						break;
					}
				}
				old=tmp;
				tmp=tmp.getNext();
			}
		}
	}
	
	public void removeAfter(T value) {
		Node<T> tmp = this.sentinel;
		while (tmp.getNext() != null) {
			if (tmp.getNext().getValue().equals(value)) {
				if (tmp.getNext().getNext() != null) {
					Node<T> aux = tmp.getNext().getNext();
					tmp.setNext(aux);
					System.gc();
					reIndex();
					break;
				}else {
					System.out.println("No se puede eliminar el valor despues de  " + value + " porque es el ultimo");
				}
			}
			tmp = tmp.getNext();
		}
	}
	
	public long indexOf(T value) {
		Node<T> tmp;
		if (!isEmpty()) {
			tmp = this.sentinel;
			while (tmp.getNext() != null) {
				if (tmp.getNext().getValue() == value) {
					return tmp.getNext().getIndex();
				}
				tmp = tmp.getNext();
			}
		}
		return -1;
	}
	
	public void list() {
		auxIetr=sentinel;
		if (!isEmpty()) {
			while(hasNext()) {
				System.out.println(next());
			}
		}
	}

	@Override
	public boolean hasNext() {
		return auxIetr.getNext()!=null;
	}

	@Override
	public String next() {
		String value = auxIetr.getNext().toString();
		auxIetr=auxIetr.getNext();
		return value;
	}

}
