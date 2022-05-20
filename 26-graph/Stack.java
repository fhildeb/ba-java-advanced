package graph;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Implementiert einen Stapel (Stack). 
 *
 */

public class Stack<E> implements Iterable<E> {
  
    private int N;                
    private Element<E> first;     

    private static class Element<Item> {
        private Item item;
        private Element<Item> next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(E item) {
        Element<E> oldfirst = first;
        first = new Element<E>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack ist leer ");
        E item = first.item;       
        first = first.next;            
        N--;
        return item;                 
    }


    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack ist leer ");
        return first.item;
    }

     public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this)
            s.append(item + " ");
        return s.toString();
    }
       

    public Iterator<E> iterator() {
        return new ListIterator<E>(first);
    }

    /**
     * Iterator zum ablaufen/traversieren des Stapels.
     *     
     */
    private class ListIterator<Item> implements Iterator<Item> {
        private Element<Item> current;

        public ListIterator(Element<Item> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


  
}
