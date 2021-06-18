package com.company.sort;

//冒泡排序，不考虑提前有序的数组情况
public class BubbleSort1 extends Sort {
    @Override
    protected void sort() {
        //一层循环，从后往前
        for (int end = array.length - 1 ; end > 0 ; end--){
            //二层循环，从前往后
            for (int i = 1;i <= end;i++){
                if (cmp(array[i],array[i-1]) < 0){
                    //交换两个数，大的排在后面，小的排在前面
                    swap(array[i],array[i-1]);
                }
            }
        }
    }
}
