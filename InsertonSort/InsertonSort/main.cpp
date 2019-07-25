//
//  main.cpp
//  InsertonSort
//
//  Created by 吉腾蛟 on 2019/7/25.
//  Copyright © 2019 JY. All rights reserved.
//

#include <iostream>
#include "SortTestHelper.h"

using namespace std;


template<typename T>

//插入排序
void insertionSort(T arr[], int n){
    //因为第0个位置的数字相当于已经进行过插入排序了
    for (int i=1; i<n; i++) {
        //寻找元素arr[i]合适的插入位置
        for (int j=i; j>0&&arr[j]<arr[j-1]; j--) {
            swap(arr[j], arr[j-1]);
        }
    }
}

int main(int argc, const char * argv[]) {
    int n=10000;
    int *arr=SortTestHelper::generateRandomArray(n, 0, n);
    insertionSort(arr, n);
    SortTestHelper::printArray(arr, n);
    
    SortTestHelper::testSort("Selection Sort", insertionSort, arr, n);
    
    delete [] arr;
    
    return 0;
}
