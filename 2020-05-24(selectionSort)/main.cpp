#include <iostream>
#include "Student.h"

using namespace std;

template<typename T>
void selectionSort(T arr[], int n){
    for(int i=0;i<n;i++){
        //寻找[i，n)区间里的最小值
        int minIndex = i;
        for (int j = i+1; j <n; ++j) {
            if (arr[j]<arr[minIndex]){
                minIndex = j;
            }
        }
        //交换
        swap(arr[i],arr[minIndex]);
    }
}
int main() {
    int a[10]={10,9,8,7,6,5,4,3,2,1};
    selectionSort(a,10);
    for (int i = 0; i < 10; ++i) {
        cout << a[i] << " ";
    }
    cout << endl;

    //对浮点类型的排序
    //这里比较好的地方是：假如使用模版的话，就不用每种类型都声明一种排序算法
    float b[4]={4.4,3.3,2.2,1.1};
    selectionSort(b,4);
    for (int j = 0; j < 4; ++j) {
        cout<<b[j]<<" ";
    }
    cout << endl;

    string c[4]={"D","C","B","A"};
    selectionSort(c,4);
    for (int k = 0; k < 4; ++k) {
        cout<<c[k]<<" ";
    }
    cout<<endl;

    Student d[4] = {{"D",90},{"90",100},{"B",95},{"A",90}};
    selectionSort(d,4);
    for (int i = 0; i < 4; ++i) {
        cout<<d[i];
    }
    cout<<endl;

    return 0;
}
