package de.neuefische.linkedlist;

public class GenericList<T> {
    private GenericListItem<T> head;

    public void add(T item) {
       // T newItem = new T(item);
        GenericListItem<T> listItem = new GenericListItem<>(item);
        if (isEmpty()) {
            setFirstItem(listItem);
        } else {
            appendToLastItem(listItem);
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void setFirstItem(GenericListItem<T> item) {
        head = item;
    }


    private void appendToLastItem(GenericListItem<T> item) {
        GenericListItem<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(item);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder(head.getValue().toString());

        GenericListItem<T> current = head.getNext();
        while (current != null) {
            builder.append(" -> ").append(current.getValue().toString());
            current = current.getNext();
        }

        return builder.toString();
    }

    public void remove(T value) {
        removeAllFromHead(value);
        removeAllFromTail(value);
    }

    private void removeAllFromHead(T value) {
        if (isEmpty()) {
            return;
        }
        while (!isEmpty() && head.contains(value)) {
            head = head.getNext();
        }
    }

    private void removeAllFromTail(T value) {
        if (isEmpty()) {
            return;
        }
        GenericListItem<T> current = head;
        while (current.getNext() != null) {

            if (current.getNext().contains(value)) {
                current.skipNext();
            } else {
                current = current.getNext();
            }
        }
    }
}
