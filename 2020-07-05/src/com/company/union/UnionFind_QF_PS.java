/*
 * @Author: your name
 * @Date: 2021-07-06 12:31:09
 * @LastEditTime: 2021-07-06 12:32:48
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/UnionFind_QF_PS.java
 */
package com.company.union;

//基于rank的路径分裂

public class UnionFind_QF_PS extends UnionFind_QF_R {

    public UnionFind_QF_PS(int capacity) {
        super(capacity);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while(v != parents[v]){
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return v;
    }
}
