package com.lpf.other;

import javax.swing.text.View;
import java.util.LinkedList;

/**
 * 给定一个 RootView，打印其内 View Tree 的每个 View。
 */
public class _PrintViewTree {

    private void recursionPrint(View root) {
        printView(root);
//        if (root instanceof ViewGroup) {
//            int count = root.getViewCount();
//            for (int i = 0; i < count; i++) {
//                View childView = root.getChiltAt(i);
//                recursionPrint(childView);
//            }
//        }
    }

    private void breathFirst(View root) {
        LinkedList<View> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            View view = list.poll();
            printView(view);
//            if (view instanceof ViewGroup) {
//                for (int i = 0; i < view.getViewCount(); i++) {
//                    View childView = view.getChildAt(i);
//                    list.addLast(childView);
//                }
//            }
        }
    }

    private void depthFirst(View root) {
        LinkedList<View> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            View view = list.pop();
            printView(view);
//            if (view instanceof ViewGroup) {
//                for (int i = 0; i < view.getViewCount(); i++) {
//                    View childView = view.getChildAt(i);
//                    list.push(childView);
//                }
//            }
        }
    }

    private void printView(View view) {
        System.out.println(view);
    }
}
