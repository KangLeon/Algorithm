package com.company.sort;

public class MergeSort<E extends Comparable<E>> extends Sort<E> {
    private E[] leftArray;

    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[array.length >> 1];
    }

    /*
    * 对[begin,end)范围的数据进行归并排序
    * */
    private void sort(int begin,int end){
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort(begin,mid);
        sort(mid,end);
        merge(begin,mid,end);
    }

    /*
    * 将[begin,mid)和[mid,end)范围的序列合并成一个有序序列
    * */
    private void merge(int begin,int mid,int end){
        int li = 0, le = end-begin;
        int ri = mid,re = end;
        int ai = begin;

        //备份左边数组
        for (int i = 0; i < le; i++) {
            leftArray[i] = array[begin + i];
        }

        //如果左边还没有结束
        while(li < le){
            if (ri < re && cmp(leftArray[li], array[ri]) < 0){
                array[ai++] = leftArray[li++];
            }else {
                array[ai++] = array[ri++];
            }
        }
    }
}
