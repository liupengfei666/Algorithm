package com.lpf.other;

import com.lpf.ListNode;

/**
 * 147.对链表进行插入排序
 */
public class _147InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        //链表为空或者只有一个数据则直接返回
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummyHead;
                while(pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode newNode = insertionSortList(node);
        while (newNode != null) {
            System.out.print(newNode.val + "-");
            newNode = newNode.next;
        }
    }
}
