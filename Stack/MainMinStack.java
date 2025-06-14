package Stack;


public class MainMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-1);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
