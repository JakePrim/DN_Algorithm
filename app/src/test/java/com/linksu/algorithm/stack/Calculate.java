package com.linksu.algorithm.stack;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by suful on 2018/2/4.
 * 应用堆栈实现逆波兰表达式
 */

public class Calculate {

    //设置一个转化堆栈 将中缀表达式转为后缀表达式
    private char[] elementData;

    private int size;

    //转化堆栈的指针
    private int elementCount = 0;

    //记录堆栈 用于记录转换的后缀表达式
    private char[] recordData;

    //记录堆栈指针
    private int recordCount = 0;

    //计算堆栈 用于计算后缀表达式的栈
    private char[] calculateData;

    private static final String TAG = "Calculate";

    public Calculate() {
        recordData = new char[20];
        calculateData = new char[20];
        elementData = new char[20];
        elementData[0] = '#';//初始时将堆栈顶设置为#
        size = 1;
    }

    //操作符优先级
    private Object[] operator = new Object[]{'+', '-', '*', '/', '(', ')', '#'};

    //将中缀表达式转化为后缀表达式 9 + (3 - 1)*3+10/2
    Object changeData(char[] inchar) {
        char[] chars = inchar;
        for (char aChar : chars) {
            conversion(aChar);
        }
        return Arrays.toString(recordData);
    }

    /**
     * 数字输出，运算符进栈，括号匹配出栈，栈顶优先级低出栈
     *
     * @param aChar
     */
    private void conversion(char aChar) {
        if (Character.isDigit(aChar)) {//true 为数字
            addRecordElement(aChar);//进入记录栈
            System.out.println("aChar 数字输出 = [" + aChar + "]");
        } else { //FALSE 不为数字 判断是否为操作符
            if (isOperator(aChar)) {//true 为操作符
                priority(aChar);
            } else {
                Log.e(TAG, "不是有效的中缀表达式");
            }
        }
    }

    /**
     * 优先级的处理
     * 括号匹配出栈，栈顶优先级低出栈
     * 9 + (3 - 1)*3+10/2
     *
     * @param aChar
     */
    private void priority(char aChar) {
        compared(elementData[elementCount], aChar);
    }

    /**
     * @param aChar 与转换栈的栈顶对比优先级
     */
    private void compared(char topChar, char aChar) {
        if (topChar == '#' && aChar == '#') {
            return;
        }
        if (topChar == '+') {//栈顶为+
            matchAdd(topChar, aChar);
        } else if (topChar == '-') {//栈顶为-
            matchLess(topChar, aChar);
        } else if (topChar == '*') { //栈顶为 *
            matchMultiply(topChar, aChar);
        } else if (topChar == '/') { //栈顶为 //
            matchMultiply(topChar, aChar);
        } else if (topChar == '(') {
            matchLeft(aChar);
        } else if (topChar == ')') {
            matchRight(topChar, aChar);
        } else if (topChar == '#') {
            matchOther(aChar);
        }
    }

    /**
     * 匹配 # 优先级
     *
     * @param aChar
     */
    private void matchOther(char aChar) {
        if (aChar == '+') { // x1 > x2
            addElement(aChar);
        } else if (aChar == '-') {
            addElement(aChar);
        } else if (aChar == '*') {//  x1 < x2   将x2 入栈
            addElement(aChar);
        } else if (aChar == '/') {// / > +
            addElement(aChar);
        } else if (aChar == '(') {// ( > +
            addElement(aChar);//转换栈添加 /
        } else if (aChar == '#') {
            return;
        }
    }

    /**
     * 匹配 ） 优先级
     *
     * @param topChar
     * @param aChar
     */
    private void matchRight(char topChar, char aChar) {
        if (aChar == '+') {
            topAboveChar(topChar, aChar);
        } else if (aChar == '-') {
            topAboveChar(topChar, aChar);
        } else if (aChar == '*') {
            topAboveChar(topChar, aChar);
        } else if (aChar == '/') {
            topAboveChar(topChar, aChar);
        } else if (aChar == ')') {
            topAboveChar(topChar, aChar);
        } else if (aChar == '#') {
            topAboveChar(topChar, aChar);
        }
    }

    /**
     * 匹配 （ 优先级
     *
     * @param aChar
     */
    private void matchLeft(char aChar) {
        if (aChar == '+') { // x1 > x2
            addElement(aChar);
        } else if (aChar == '-') {
            addElement(aChar);
        } else if (aChar == '*') {//  x1 < x2   将x2 入栈
            addElement(aChar);
        } else if (aChar == '/') {// / > +
            addElement(aChar);
        } else if (aChar == '(') {// ( > +
            addElement(aChar);//转换栈添加 /
        } else if (aChar == ')') {// ) < + 匹配出栈
            removeElementAt(elementCount);
        }
    }

    /**
     * 匹配 * 的优先级
     *
     * @param topChar
     * @param aChar
     */
    private void matchMultiply(char topChar, char aChar) {
        if (aChar == '+') { // x1 > x2
            topAboveChar(topChar, aChar);
        } else if (aChar == '-') {
            topAboveChar(topChar, aChar);
        } else if (aChar == '*') {//  x1 < x2   将x2 入栈
            topAboveChar(topChar, aChar);
        } else if (aChar == '/') {// / > +
            topAboveChar(topChar, aChar);
        } else if (aChar == '(') {// ( > +
            addElement(aChar);//转换栈添加 /
        } else if (aChar == ')') {// ) < + 匹配出栈
            topAboveChar(topChar, aChar);
        } else if (aChar == '#') {
            topAboveChar(topChar, aChar);
        }
    }

    /**
     * 匹配 - 的优先级
     *
     * @param topChar
     * @param aChar
     */
    private void matchLess(char topChar, char aChar) {
        if (aChar == '+') { // x1 > x2
            topAboveChar(topChar, aChar);
        } else if (aChar == '-') {
            topAboveChar(topChar, aChar);
        } else if (aChar == '*') {//  x1 < x2   将x2 入栈
            addElement(aChar);//转换栈添加 *
        } else if (aChar == '/') {// / > +
            addElement(aChar);
        } else if (aChar == '(') {// ( > +
            addElement(aChar);//转换栈添加 /
        } else if (aChar == ')') {// ) < + 匹配出栈
            topAboveChar(topChar, aChar);
        } else if (aChar == '#') {
            topAboveChar(topChar, aChar);
        }
    }

    /**
     * 匹配 + 的优先级
     *
     * @param topChar
     * @param aChar
     */
    private void matchAdd(char topChar, char aChar) {
        if (aChar == '-') {//- < + - 出栈 x1 > x2    x1 退栈输出
            topAboveChar(topChar, aChar);
        } else if (aChar == '+') { // + < + 出栈
            topAboveChar(topChar, aChar);
        } else if (aChar == '*') {// * > + x1 < x2   将x2 入栈
            addElement(aChar);//转换栈添加 *
        } else if (aChar == '/') {// / > +
            addElement(aChar);
        } else if (aChar == '(') {// ( > +
            addElement(aChar);//转换栈添加 /
        } else if (aChar == ')') {// ) < + 匹配出栈
            topAboveChar(topChar, aChar);
        } else if (aChar == '#') {
            topAboveChar(topChar, aChar);
        }
    }

    /***
     * 栈顶的优先级高于 扫描到的预算符的优先级
     * @param topChar
     * @param aChar
     */
    private void topAboveChar(char topChar, char aChar) {
        System.out.println("topAboveChar --> 运算符输出：" + topChar);
        removeElementAt((elementCount));//x1 退栈
        addRecordElement(topChar);//-进入记录栈
        //x2 继续与最新的栈顶 优先级
        compared(elementData[(elementCount)], aChar);
    }

    /**
     * 判断是否为操作符
     *
     * @param aChar
     * @return
     */
    private boolean isOperator(char aChar) {
        for (int i = 0; i < operator.length; i++) {
            if (aChar == (Character) operator[i]) {
                return true;
            }
        }
        return false;
    }


    /**
     * 添加到栈
     *
     * @param obj
     */
    public synchronized void addElement(char obj) {
        elementCount = elementCount + 1;
        elementData[elementCount] = obj;
        ++size;
    }

    public synchronized void addRecordElement(char obj) {
        recordData[++recordCount] = obj;
    }

    /**
     * 移除栈
     *
     * @param index
     */
    public synchronized void removeElementAt(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    size);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = size - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        --size;
        --elementCount;
        elementData[index] = ' '; /* to let gc do its work */
    }

}
