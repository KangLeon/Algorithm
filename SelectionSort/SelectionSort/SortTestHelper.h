//
//  SortTestHelper.h
//  SelectionSort
//
//  Created by 吉腾蛟 on 2019/7/24.
//  Copyright © 2019 JY. All rights reserved.
//

#ifndef SortTestHelper_h
#define SortTestHelper_h

#include <iostream>
#include <ctime>
#include <cassert>

using namespace std;

namespace SortTestHelper {
    //生成有n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    int *generateRandomArray(int n, int rangeL, int rangeR) {
        
        assert(rangeL <= rangeR);
        
        int *arr = new int[n];
        
        srand(time(NULL));
        for (int i = 0; i < n; i++)
            arr[i] = rand() % (rangeR - rangeL + 1) + rangeL;
        return arr;
    }
    
    template<typename T>
    void printArray(T arr[], int n){
        for (int i=0; i<n; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        
        return;
    }
    
    template<typename T>
    bool isSorted(T arr[], int n){
        for (int i=0; i<n-1; i++) {
            if (arr[i]>arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    
    template<typename T>
    void testSort( string sortName, void(*sort)(T[], int), T arr[], int n){
        clock_t startTime=clock();
        sort(arr,n);
        clock_t endTime = clock();
        
        assert(isSorted(arr,n));
        cout << sortName << " : " << double(endTime - startTime) / CLOCKS_PER_SEC << " s" << endl;
        
        return;
    }
    
    int *copyIntArray(int a[], int n){
        int *arr=new int[n];
        //头指针、尾指针、拷贝到目的地址的头指针
        copy(a, a+n, arr);
        return arr;
    }
}

#endif /* SortTestHelper_h */