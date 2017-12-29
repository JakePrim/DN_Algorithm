package com.linksu.algorithm.list;

/**
 * Created by suful on 2017/12/24.
 */

public class LinkedList<E> {
    public LinkedList() {
    }

    Node<E> frist;

    Node<E> last;

    int size;


    /**
     * 向链表的尾部添加一个元素
     *
     * @param e
     */
    public void add(E e) {
        linkLast(e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) return;

        if (index == size) {//插入尾部
            linkLast(e);
        } else {
            Node<E> currentNode = node(index);//拿到当前位置要插入的节点
            Node<E> prev = currentNode.prev;
            Node<E> newNode = new Node<>(prev, e, currentNode);
            if (prev == null) {//头部插入
                frist = newNode;
            } else {//中间插入
                prev.next = newNode;//Note : 这里两个位置不能换
            }
            currentNode.prev = newNode;//Note: 查到的节点prev 要指向新的节点
            size++;
        }

    }

    public void remove(int index) {
        if (index < 0 || index > size) return;
        unLinkNode(node(index));
    }

    private void unLinkNode(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev == null){
            frist = next;
        }else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null){
            last = prev;
        }else {
            next.prev = prev;
            node.next = null;
        }
        size --;
    }

    /**
     * 获取某个节点的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) return null;
        return node(index).item;
    }

    private Node<E> node(int index) {
        if ((size >> 1) < index) {//从尾部开始循环
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = last.prev;
            }
            return node;
        } else {//从头部开始循环
            Node<E> node = frist;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

    private void linkLast(E e) {
        Node<E> newNode = new Node<>(last, e, null);
        Node<E> l = last;//拿到之前的最后一个节点
        last = newNode;//将添加的新节点newNode 赋给last 最后一个节点
        if (l == null) {//如果之前的最后一个节点为空
            frist = newNode;
        } else {//如果之前的最后一个节点不为空
            l.next = newNode;
        }
        size++;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
