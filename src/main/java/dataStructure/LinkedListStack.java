package dataStructure;

import java.util.List;

/*
ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
void push(int data)를 구현하세요.
int pop()을 구현하세요.
 */
public class LinkedListStack {
    public LinkedListStack() {
    }

    public void push(ListNode head, ListNode add) {
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = add;
    }

    public int pop(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        if (current == head) {
            return head.getData();
        }
        previous.next = null;
        return current.getData();
    }
}
