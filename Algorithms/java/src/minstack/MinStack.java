package minstack;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();

    }

    void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }

    }

    void pop() {
        minStack.pop();
        mainStack.pop();
    }

    int top() {
        return mainStack.peek();

    }

    int getMin() {
        return minStack.peek();
    }
}


/*
Success
Details
Runtime: 5 ms, faster than 74.07% of Java online submissions for Min Stack.
Memory Usage: 41.4 MB, less than 10.15% of Java online submissions for Min Stack.

 */