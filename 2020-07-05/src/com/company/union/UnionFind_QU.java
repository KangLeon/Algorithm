/*
 * @Author: your name
 * @Date: 2021-07-05 15:07:13
 * @LastEditTime: 2021-07-06 11:16:05
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/UnionFind_QU.java
 */
package com.company.union;

public class UnionFind_QU extends Unionfind {
    public UnionFind_QU(int capacity) {
        super(capacity);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while(v!=parents[v]){
            v=parents[v];
        }
        return v;
    }

    /**
     * @description: 将v1的根节点嫁接到v2的根节点
     * @param {*}
     * @return {*}
     */    
    @Override
    public void union(int v1, int v2) {
        // TODO Auto-generated method stub
        int p1 = find(v1);
        int p2 = find(v2); 
        if(p1==p2)return;
        parents[p1]=p2;
    }
    
}
