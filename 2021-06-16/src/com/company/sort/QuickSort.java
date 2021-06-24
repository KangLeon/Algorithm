package com.company.sort;

public class QuickSort<E extends Comparable<E>> extends Sort<E>  {
    @Override
    protected void sort() {
        sort(0,array.length);
    }

    /*
    * 对[begin,end)范围的元素进行快速排序
    * @param begin
    * @param end
    * */
    private void sort(int begin,int end){
        if (end - begin < 2) return;
        //确定轴点位置
        int mid = privotIndex(begin,end);
        //对子序列进行快速排序
        sort(begin,end);
        sort(mid+1,end);
    }

    /*
    * 构造出[begin,end）范围的轴点元素
    * @return轴点元素的最终位置
    * */
    private int privotIndex(int begin,int end){
        //备份begin位置的元素
        E v = array[begin];
        //end指向最后一个元素
        end--;

        while (begin < end){

        }
    }
}
