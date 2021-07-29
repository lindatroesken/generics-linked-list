package de.neuefische.linkedlist;

public class GenericListItem<T> {


    private T value;
    private GenericListItem<T> next;

    public GenericListItem(T t) {
        this.value = t;
    }

    public boolean contains(T value){
        return this.value.equals(value);
    }

    public void skipNext(){
        next = next.getNext();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericListItem<T> getNext() {
        return next;
    }

    public void setNext(GenericListItem<T> next) {
        this.next = next;
    }
}
