/*
 * @Author: your name
 * @Date: 2021-07-06 12:04:33
 * @LastEditTime: 2021-07-06 12:30:56
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/UnionFind_QF_PC.java
 */
package com.company.union;

//基于rank的路径压缩

public class UnionFind_QF_PC extends UnionFind_QF_R {

    public UnionFind_QF_PC(int capacity) {
        super(capacity);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        if(parents[v]!=v){
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
