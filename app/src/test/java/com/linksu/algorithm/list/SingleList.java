package com.linksu.algorithm.list;

/**
 * Created by suful on 2017/12/29.
 */

public class SingleList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> frist;

    private Node<E> last;

    public int size;

    /**
     * 向尾部添加一个元素
     *
     * @param e
     */
    public void add(E e) {
        lastList(e);
    }

    /**
     * 在某个位置插入一个元素
     *
     * @param e
     * @param index
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) return;
        if (index == size) {//插入尾部
            lastList(e);
        } else {
            if (index == 0) {
                Node<E> l = frist;
                Node<E> newNode = new Node<>(e, l);//新的元素在插入位置的前一个位置
                frist = newNode;
            } else {
                Node<E> fNode = node(index - 1);//找到要插入位置的前一个位置
                Node<E> lNode = fNode.next;
                Node<E> newNode = new Node<>(e, lNode);
                fNode.next = newNode;
            }
            size++;
        }

    }

    /**
     * 删除某个节点
     *
     * @param index
     */
    public void remove(int index) {
        unLink(index);
    }

    private void unLink(int index) {
        if (index < 0 || index > size) return;
        if (index == size) {//删尾部
            Node<E> node = node(index - 1);
            node.next = null;
            last = node;
        } else if (index == 0) {//删头部
            Node<E> l = this.frist;
            frist = l.next;
        } else {
            Node<E> node = node(index - 1);//要删除的前一个节点
            Node<E> removeNode = node.next;//要删除的节点
            Node<E> lNode = removeNode.next;//要删除的后一个节点
            node.next = lNode;
        }
        size--;
    }

    public void remove(E e) {
        Node<E> newNode = frist;
        int index = -1;
        for (int i = 0; i < size; i++) {
            newNode = newNode.next;
            if (e.equals(newNode.item)) {
                index = i;
                break;
            }
        }
        if (index != -1)
            unLink(index);
    }

    private void lastList(E e) {
        Node<E> newNode = new Node<>(e, null);//一个新的节点

        Node<E> l = last;

        last = newNode;//将最后一个节点赋值
        if (l == null) {
            frist = newNode;
        } else {
            l.next = newNode;
        }

        size++;
    }

    /**
     * 获取节点的某个元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return node(index).item;
    }

    public Node<E> node(int index) {
        Node<E> newNode = frist;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        return newNode;
    }

    /**
     * 单链表的逆置
     * 第一种方法实现
     */
    public void inverse() {
        Node<E> l = this.last;
        Node<E> curr = this.frist;
        Node<E> reve = null;
        while (curr != null) {
            Node<E> temp = curr;
            curr = curr.next;
            temp.next = reve;
            reve = temp;
        }
        frist = reve;
    }
}
