package graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementiert eine Warteschlange.
 */
public class Queue<E> implements Iterable<E> {
    private int s; // Anzahl der Elemente in der Queue
    private Node<E> first; // Beginn
    private Node<E> last; // Ende

    // statische Hilfsklasse
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    /**
     * Konstruktor.
     */
    public Queue() {
        first = null;
        last = null;
        s = 0;
    }

    /**
     * Ist die Queue leer?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Größe der Warteschlange.
     */
    public int size() {
        return s;
    }

    /**
     * Gibt das am "längsten wartende" Element zurück.
     */
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue leer");
        return first.item;
    }

    /**
     * Fügt ein neues item in die Schlange ein.
     *
     */
    public void enqueue(E item) {
        Node<E> oldlast = last;
        last = new Node<E>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        s++;
    }

    /**
     * Gibt das am längsten in der Queue gespeicherte Element zurück.
     *
     * @return das älteste Element(Item)
     * @throws java.util.NoSuchElementException falls Queue leer ist.
     */
    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue leer");
        E item = first.item;
        first = first.next;
        s--;
        if (isEmpty())
            last = null;
        return item;
    }

    /**
     * Erzeugt eine Zeichenkette, mit allen in der Warteschlange gespeicherten
     * Elementen.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this)
            s.append(item + " ");
        return s.toString();
    }

    /**
     * Gibt einen Iterator zum traversieren der Schlange zurück.
     * Die Reihenfolge der Elemente entspricht dem FIFO-Prinzip.
     * 
     */
    public Iterator<E> iterator() {
        return new ListIterator<E>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        // wird nicht gebenötigt und ist laut Interface optional
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}