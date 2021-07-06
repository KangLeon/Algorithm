/*
 * @Author: your name
 * @Date: 2021-07-06 12:38:59
 * @LastEditTime: 2021-07-06 12:41:00
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/UnionFind_QF_PH.java
 */
package com.company.union;

//基于rank的优化：路径减半

public class UnionFind_QF_PH extends UnionFind_QF_R {

    public UnionFind_QF_PH(int capacity) {
        super(capacity);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int find(int v) {
        rangeCheck(v);

        while (v != parents[v]) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return v;
    }
    
}
