package ch4.generic;

import java.util.ArrayList;

public class WhatIs {

    public static void main(String[] args) {
        // 创建ArrayList<Integer>类型：
        ArrayList<Integer> integerList = new ArrayList<>();
// 添加一个Integer：
//        integerList.add(123);
// “向上转型”为ArrayList<Number>：
//        ArrayList<Number> numberList = integerList;
// 添加一个Float，因为Float也是Number：
//        numberList.add(new Float(12.34));
// 从ArrayList<Integer>获取索引为1的元素（即添加的Float）：
        Integer n = integerList.get(1); // ClassCastException!
    }
}
