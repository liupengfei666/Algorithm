package com.lpf.basic.class02;

import java.util.Stack;

public class Code06_TwoStackImplementQueue {

    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void push(int value) {
            stackPush.push(value);
            pushToPop();
        }

        private void pushToPop() {
            //stackPush 向stackPop倒入数据
            if (stackPop.empty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public int poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
