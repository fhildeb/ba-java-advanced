package list;

/**
 * Listen-Element fuer einfach verkettete lineare Listen
 */

class ListElement {

    Object data = null;
    ListElement next = null;

    ListElement(Object data) {
        this.data = data;
    }

    ListElement(Object data, ListElement next) {
        this.data = data;
        this.next = next;
    }
}
