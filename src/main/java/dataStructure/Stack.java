package dataStructure;

/*
int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
void push(int data)를 구현하세요.
int pop()을 구현하세요.
 */
public class Stack {
    int[] memory;
    int index;
    int size;

    public Stack(int size) {
        this.size = size;
        memory = new int[size];
        index = 0;
    }

    public void push(int data) {
        if (this.index >= size) {
            System.out.println("push error");
            return;
        }
        memory[index] = data;
        index++;
    }

    public int pop() {
        index--;
        if (index < 0) {
            System.out.println("pop error");
            return 0;
        }
        return memory[index];
    }
}
