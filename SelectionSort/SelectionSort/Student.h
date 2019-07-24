//
//  Student.h
//  SelectionSort
//
//  Created by 吉腾蛟 on 2019/7/24.
//  Copyright © 2019 JY. All rights reserved.
//

#ifndef Student_h
#define Student_h

#include<iostream>
#include<string>

using namespace std;

struct Student {
    string name;
    int score;
    
    //小于号的重载
    bool operator<(const Student &otherStudent){
        return score!=otherStudent.score ? score<otherStudent.score : name<otherStudent.name;
    }
    
    friend ostream& operator<<(ostream &os, const Student &student){
        os<<"Student: "<<student.name<<" "<<student.score<<endl;
        return os;
    }
};

#endif /* Student_h */
