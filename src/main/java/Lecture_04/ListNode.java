package Lecture_04;

public class ListNode {
    private int value;
    private ListNode previous, next;

    public void setValue(int value) {
        this.value = value;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public ListNode(int value, ListNode previous, ListNode next){
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}
