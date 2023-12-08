package Lecture_04;

import javax.print.attribute.standard.SheetCollate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LinkList implements Collection<Integer> {
    private ListNode head, tail;
    private int size = 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail && head == null;
    }

    @Override
    public boolean contains(Object o) {
        //TODO
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
// TODO
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer value) {
if(head==null){
    head =new ListNode(value,null,null);
    tail = head;
}else {
    ListNode currentNode = new ListNode(value,tail,null);
    tail.setNext(currentNode);
    tail = currentNode;
}
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
