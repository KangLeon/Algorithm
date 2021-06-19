package com.company.sort;

import java.util.Arrays;

public abstract class Sort<E extends Comparable<E>> {
    protected E[] array;
    private int cmpCount;
    private int swapCount;
    private long time;

    public void sort(E[] array){
        if (array == null || array.length < 2) return;

        this.array = array;

        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis()-begin;
    }

    protected abstract void sort();
    /*
    * 返回等于0，代表 左 == 右
    * 返回小于0，代表 左 < 右
    * 返回大于0，代表 左 > 右
    *
    * 传入需要比较的索引
    * */
    protected int cmp(int i1,int i2){
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }


    /*
    * 传入比较的值
    * */
    protected int cmp(E v1,E v2){
        cmpCount++;
        return v1.compareTo(v2);
    }

    //交换
    protected void swap(int i1,int i2){
        swapCount++;
        E tmp = array[i1];
        array[i1]=array[i2];
        array[i2]=tmp;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "array=" + Arrays.toString(array) +
                ", cmpCount=" + cmpCount +
                ", swapCount=" + swapCount +
                ", time=" + time +
                '}';
    }
}
