package com.linksu.algorithm.stack;

/**
 * Created by suful on 2018/2/4.
 * 应用堆栈实现逆波兰表达式
 */

public class Calculate {

    //一个栈 将中缀表达式 转为 后缀表达式
    protected Object[] elementData;

    //栈的指针
    protected int elementCount;

    //记录栈 用于记录转换的后缀表达式
    protected Object[] recordData;

    //计算栈 用于计算后缀表达式的栈
    protected Object[] calculateData;

    public Calculate() {
        this.elementData = new Object[10];
    }

    //将中缀表达式转化为后缀表达式
    public void changeData(String a){
        char[] chars = a.toCharArray();

    }

    //添加到栈
    public synchronized void addElement(Object obj) {
        elementData[elementCount++] = obj;
    }

    //移除栈
    public synchronized void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }

}
