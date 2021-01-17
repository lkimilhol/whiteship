package dataStructure;
/*
LinkedList에 대해 공부하세요.
정수를 저장하는 ListNode 클래스를 구현하세요.
ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
 */

public class ListNode {
    ListNode next;
    int data;

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        ListNode tmpNode = head;

        for (int i = 0; i < position - 1; i++) {
            if(tmpNode.next == null) { break;}
            tmpNode = tmpNode.next;
        }

        ListNode tmp = tmpNode.next;
        tmpNode.next = nodeToAdd;
        nodeToAdd.next = tmp;

        return this;
    }

    public void remove(ListNode head, int positionToRemove) {
        ListNode tmpNode = head;

        for (int i = 0; i < positionToRemove - 1; i++) {
            if(tmpNode.next == null) { break;}
            tmpNode = tmpNode.next;
        }

        ListNode tmp = tmpNode.next;
        tmpNode.next = tmp.next;
    }

    public boolean contains(ListNode head, ListNode noteToCheck) {
        while (head != null) {
            if (head.getData() == noteToCheck.getData()) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.getData());
            head = head.next;
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}





