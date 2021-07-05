package com.company.sort;

//选择排序：选择排序的交换次数要远远少于冒泡排序，所以平均性能优于冒泡排序
//最好、最坏、平均时间复杂度：O(n^2),空间复杂度：O(1)，属于稳定排序
public class SelectionSort  extends Sort{
    @Override
    protected void sort() {
        for (int end = array.length - 1;end>0;end--){
            int maxIndex = 0;
            for (int i = 1;i<=end;i++){
                if (cmp(maxIndex,i) <= 0){
                    maxIndex = i;
                }
            }
            swap(maxIndex,end);
        }
    }
}
