//
//  main.cpp
//  SelectionSort
//
//  Created by 吉腾蛟 on 2019/7/24.
//  Copyright © 2019 JY. All rights reserved.
//

#include <iostream>
#include "Student.h"
#include "SortTestHelper.h"

using namespace std;

template<typename T>

//1.选择排序
void selectionSort(T arr[], int n){
    for(int i = 0 ; i < n ; i ++){
        int minIndex = i;
        for( int j = i + 1 ; j < n ; j ++ )
            if( arr[j] < arr[minIndex] )
                minIndex = j;
        swap( arr[i] , arr[minIndex] );
    }
}

int main() {
    int a[10]={10,9,8,7,6,5,4,3,2,1};
    selectionSort(a, 10);
    for (int i=0; i<10; i++) {
        cout << a[i] << " ";
    }
    cout <<  endl;
    
    float b[4]={4.4,3.3,2.2,1.1};
    selectionSort(b, 4);
    for (int i=0; i<4; i++) {
        cout << b[i] << " ";
    }
    cout << endl;
    
    string c[4]={"D","C","B","A"};
    selectionSort(c, 4);
    for (int i =0; i<4; i++) {
        cout << c[i] << " ";
    }
    cout << endl;
    
    Student d[4]={{"D",90},{"C",100},{"B",95},{"A",95}};
    selectionSort(d, 4);
    for (int i=0; i<4; i++) {
        cout<<d[i];
    }
    cout<<endl;
    
    int n=10000;
    int *arr=SortTestHelper::generateRandomArray(n, 0, n);
//    selectionSort(arr, n);
//    SortTestHelper::printArray(arr, n);

    SortTestHelper::testSort("Selection Sort", selectionSort, arr, n);
    
    //因为是用了new生成了数组，所以应该使用delete[]释放内存
    delete [] arr;
    
    return 0;
}