package list;

public class ObjectStack {
    SimpleList stacklist;

    public ObjectStack() {
        stacklist = new SimpleList();
    }

    public void push(Object e) {
        stacklist.insertFirst(e);
    }

    public Object pop() {
        return stacklist.deleteFirst();
    }

    public boolean isEmpty() {
        return stacklist.isEmpty();
    }

    public String toString() {
        return stacklist.toString();
    }

}