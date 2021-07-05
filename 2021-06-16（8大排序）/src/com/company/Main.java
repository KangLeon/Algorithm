package com.company;

//冒泡排序

import com.company.sort.InsertionSort2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] array =new Integer[] {7,2,4,6,9,1,2,3,4,5,7};

        new InsertionSort2().sort(array);

        for (Integer number : array) {
            System.out.println(number);
        }
    }
}
