package list;

import java.util.NoSuchElementException;

public class SimpleList {
	ListElement first;

	public SimpleList() {
		first = null;
	}

	public SimpleList(ListElement first) {
		this.first = first;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void clear() {
		first = null;
	}

	public Object getFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		return first.data;
	}

	public void insertFirst(Object data) {
		ListElement le = new ListElement(data, first);
		first = le;
	}

	public Object deleteFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		Object retval = first.data;
		first = first.next;
		return retval;
	}

	public String toString() {
		ListElement elem = first;
		String retval = "";
		while (elem != null) {
			retval += "-> " + elem.data.toString();
			elem = elem.next;
		}
		return retval;
	}

	public static void main(String[] args) {
		ListElement le = new ListElement(25);
		SimpleList sl = new SimpleList(le);
		sl.insertFirst(24);
		sl.insertFirst(1337);

		System.out.println(sl.toString());
		System.out.println(sl.getFirst().toString());

		sl.deleteFirst();

		System.out.println(sl.getFirst().toString());

		System.out.println(sl.isEmpty());
		sl.clear();
		System.out.println(sl.isEmpty());
	}

}
