/*
 * @Author: your name
 * @Date: 2021-07-05 13:21:27
 * @LastEditTime: 2021-07-05 15:00:49
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/main.java
 */
package com.company;

import com.company.union.UnionFind_QF;
import com.company.union.Unionfind;

public class Main {
    public static void main(String[] args) {
        Unionfind uf = new UnionFind_QF(12);
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(0, 3);
        uf.union(0, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        System.out.println(uf.isSame(0, 6));  
        System.out.println(uf.isSame(0, 5));
    }
}
