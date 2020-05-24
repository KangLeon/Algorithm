//
// Created by JY on 2020/5/24.
//

#ifndef INC_2020_05_24_SELECTIONSORT__STUDENT_H
#define INC_2020_05_24_SELECTIONSORT__STUDENT_H

#include <iostream>
#include <string>

//少用这个，因为会涉及到命名环境污染
using namespace std;

struct Student{
    string name;//姓名
    int score;//分数

    //小于号运算符的重载
    bool operator<(const Student &otherStudent){
        return score!=otherStudent.score ? score < otherStudent.score : name<otherStudent.name;
    }

    //输出运算符重载
    friend ostream& operator<<(ostream &os,const Student &student){
        os<<"Student: "<<student.name<<" "<<student.score;
        return os;
    }
};


#endif //INC_2020_05_24_SELECTIONSORT__STUDENT_H
