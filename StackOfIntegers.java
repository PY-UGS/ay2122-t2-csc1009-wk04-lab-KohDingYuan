import java.util.Arrays;

public class StackOfIntegers{
    private int[] elements = new int[0];
    private int size = 0;

    public StackOfIntegers(){
    }
    public StackOfIntegers(int capacity) {
        this.elements = new int[capacity];
        this.size = capacity;
    }

    public boolean empty(){
        return this.elements.length == 0;
    }
    public int peek() throws Exception{
        if (this.size == 0) throw new Exception("Your stack is empty");
        return this.elements[this.size - 1];
    }

    public void push(int value){
        int[] newStack = Arrays.copyOf(this.elements, this.size + 1);
        newStack[this.size] = value;

        this.elements = newStack;
        this.size++;
    }
    public int pop() throws Exception{
        if (this.size == 0) throw new Exception("Your stack is empty");
        int returnValue = this.elements[this.size - 1];
        this.elements = Arrays.copyOf(this.elements, this.size - 1);
        this.size--;
        return returnValue;
    }
    public int getSize(){
        return this.size;
    }
}