package com.lpf.basic.class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code07_TwoQueueImplementStack {

    public static class TwoQueueStack<T> {
        private Queue<T> queue;
        private Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value) {
            queue.add(value);
        }

        public T pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        public T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");
        TwoQueueStack<Integer> mystack = new TwoQueueStack<>();
        Stack<Integer> stack = new Stack<>();
        int testTimes = 100000;
        int max = 100000;
        for (int i = 0; i < testTimes; i++) {
            if (mystack.isEmpty()) {
                if (!stack.isEmpty()) {
                    System.out.println("oops");
                }
                int num = (int) (Math.random() * max);
                mystack.push(num);
                stack.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    mystack.push(num);
                    stack.push(num);
                } else if (Math.random() < 0.5) {
                    if (!mystack.peek().equals(stack.peek())) {
                        System.out.println("oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!mystack.pop().equals(stack.pop())) {
                        System.out.println("oops");
                    }
                } else {
                    if (mystack.isEmpty() != stack.isEmpty()) {
                        System.out.println("oops");
                    }
                }
            }
        }
        System.out.println("finish");
    }
}
