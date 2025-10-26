class myStack {
    int[] st;
    int capacity = 0;
    int top = -1;
    
    public myStack(int n) {
        st = new int[n];
        capacity = n;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int x) {
        st[++top] = x;
    }

    public void pop() {
        if (!isEmpty()) top--;
    }

    public int peek() {
        if (isEmpty()) return -1;
        
        return st[top];
    }
}