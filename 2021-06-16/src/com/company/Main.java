package com.company;

//冒泡排序

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] array =new Integer[] {7,2,4,6,9,1,2,3,4,5,7};

        selectionSort(array);

        for (Integer number : array) {
            System.out.println(number);
        }
    }

    //冒泡排序，不考虑提前有序的数组情况
    static void bubbleSort1(Integer[] array){
        //一层循环，从后往前
        for (int end = array.length - 1 ; end > 0 ; end--){
            //二层循环，从前往后
            for (int i = 1;i <= end;i++){
                if (array[i]<array[i-1]){
                    //交换两个数，大的排在后面，小的排在前面
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }
        }
    }

    //冒泡排序，考虑提前有序的数组情况1
    static  void bubbleSort2(Integer[] array){
        //一层循环，从后往前
        for (int end = array.length - 1;end > 0;end--){
            boolean sorted = true;
            //二层循环，从前往后
            for (int i = 1;i <= end;i++){
                if (array[i]<array[i-1]){
                    //交换两个数，大的排在后面，小的排在前面
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    //冒泡排序，考虑提前有序的数组情况2
    static  void bubbleSort3(Integer[] array){
        //一层循环，从后往前
        for (int end = array.length - 1;end > 0;end--){
            int sortedIndex = 1;
            //二层循环，从前往后
            for (int i = 1;i <= end;i++){
                if (array[i]<array[i-1]){
                    //交换两个数，大的排在后面，小的排在前面
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    sortedIndex = i;
                }
            }
            end = sortedIndex;
        }
    }

    //选择排序：选择排序的交换次数要远远少于冒泡排序，所以平均性能优于冒泡排序
    static void selectionSort(Integer[] array){
        for (int end = array.length - 1;end>0;end--){
            int maxIndex = 0;
            for (int i = 1;i<=end;i++){
                if (array[maxIndex]<=array[i]){
                    maxIndex = i;
                }
            }
            int temp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = temp;
        }
    }
}
