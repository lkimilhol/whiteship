package dataStructure;

public class Queue {
    int[] arr;
    int size;
    int index;
    public Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.index = 0;
    }

    public void add(int data) {
        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = data;
        this.index++;
    }

    public int poll() {
        int data = arr[index - 1];
        this.index--;
        return data;
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
        }
    }
}
