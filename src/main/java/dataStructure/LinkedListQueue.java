package dataStructure;

public class LinkedListQueue {
    ListNode head;

    public LinkedListQueue() {
//        this.head = new ListNode();
    }
    public void add(ListNode add) {
        add.next = head;
        this.head = add;
    }

    public int poll() {
        ListNode current = this.head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;

        return current.getData();
    }

    public void print() {
        ListNode tmp = head;
        while (tmp.next != null) {
            System.out.println(tmp.getData());
            tmp = tmp.next;
        }
        System.out.println(tmp.getData());
    }
}
