package com.lpf.other;

import java.util.HashMap;

/**
 * https://mp.weixin.qq.com/s/P9_BH0WJ_H3tjItnqsRlcQ
 */
public class _LruCache {

    public static class LruCache {

        private static Node mHead;
        private static Node mTail;
        //缓存上限
        private static int mLimit;
        private static HashMap<String, Node> mHashMap;

        public LruCache(int limit) {
            this.mLimit = limit;
            mHashMap = new HashMap<>();
        }

        private static String get(String key) {
            Node node = mHashMap.get(key);
            if (node == null) {
                return null;
            }
            refreshNode(node);
            return node.value;
        }

        private static void put(String key, String value) {
            Node node = mHashMap.get(key);
            if (node == null) {
                //如果key不存在，插入key-value
                if (mHashMap.size() >= mLimit) {
                    String oldKey = removeNode(mHead);
                    mHashMap.remove(oldKey);
                }
                node = new Node(key, value);
                addNode(node);
                mHashMap.put(key, node);
            } else {
                //如果key存在，刷新key-value
                node.value = value;
                mHashMap.put(key, node);
            }
        }

        private static void remove(String key) {
            Node node = mHashMap.get(key);
            removeNode(node);
            mHashMap.remove(key);
        }

        /**
         * 刷新被访问的节点位置
         *
         * @param node 节点
         */
        private static void refreshNode(Node node) {
            //如果访问的是尾节点，无需移动
            if (node == mTail) {
                return;
            }
            //移除节点
            removeNode(node);
            //添加节点
            addNode(node);
        }

        /**
         * 删除节点
         *
         * @param node 要删除的节点
         */
        private static String removeNode(Node node) {
            if (node == mTail) {
                //移除尾节点
                mTail = mTail.pre;
            } else if (node == mHead) {
                //移除头节点
                mHead = mHead.next;
            } else {
                //移除中间节点
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            return node.key;
        }

        /**
         * 尾部插入节点
         *
         * @param node 要插入的节点
         */
        private static void addNode(Node node) {
            if (mHead == null) {
                mHead = node;
            }
            if (mTail != null) {
                mTail.next = node;
                node.pre = mTail;
                node.next = null;
            }
            mTail = node;
        }

        private static class Node {

            String key;
            String value;
            Node pre;
            Node next;

            public Node(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(5);
        lruCache.put("001", "用户1信息");
        lruCache.put("002", "用户1信息");
        lruCache.put("003", "用户1信息");
        lruCache.put("004", "用户1信息");
        lruCache.put("005", "用户1信息");
        System.out.println(lruCache.get("002"));
        lruCache.put("004", "用户2信息更新");
        lruCache.put("006", "用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }

}
