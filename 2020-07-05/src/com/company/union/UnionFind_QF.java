/*
 * @Author: your name
 * @Date: 2021-07-05 15:02:18
 * @LastEditTime: 2021-07-05 16:06:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/UnionFind_QF.java
 */
package com.company.union;

public class UnionFind_QF extends Unionfind {
    
    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    public int find(int v){
        rangeCheck(v);

        return parents[v];
    }

    /**
     * @description: 将v1所在的集合所有元素都嫁接到v2的父节点上
     * @param {int} v1
     * @param {int} v2
     * @return {*}
     */    
    public void union(int v1,int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1==p2)return;

        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == p1){
                parents[i] = p2;
            }
        }
    }
}
