package de.neuefische.linkedlist;

import java.util.ArrayList;

public class AnimalList {

    private AnimalListItem head;

    public void add(Animal animal) {
        AnimalListItem newItem = new AnimalListItem(animal);
        if (isEmpty()) {
            setFirstItem(newItem);
        } else {
            appendToLastItem(newItem);
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void setFirstItem(AnimalListItem item) {
        head = item;
    }

    private void appendToLastItem(AnimalListItem item) {
        AnimalListItem current = head;
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

        StringBuilder builder = new StringBuilder(head.getValue().getName());

        AnimalListItem current = head.getNext();
        while (current != null) {
            builder.append(" -> ").append(current.getValue().getName());
            current = current.getNext();
        }

        return builder.toString();
    }

    public void remove(Animal animal) {
        removeAllFromHead(animal);
        removeAllFromTail(animal);
    }

    private void removeAllFromHead(Animal value) {
        if (isEmpty()) {
            return;
        }
        while (!isEmpty() && head.contains(value)) {
            head = head.getNext();
        }
    }

    private void removeAllFromTail(Animal value) {
        if (isEmpty()) {
            return;
        }
        AnimalListItem current = head;
        while (current.getNext() != null) {

            if (current.getNext().contains(value)) {
                current.skipNext();
            } else {
                current = current.getNext();
            }
        }
    }
}
