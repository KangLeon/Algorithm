/*
 * @Author: your name
 * @Date: 2021-07-05 15:07:13
 * @LastEditTime: 2021-07-06 10:43:02
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/UnionFind_QU.java
 */
package com.company.union;

public class UnionFind_QU extends Unionfind {

    private int[] sizes;

    public UnionFind_QU(int capacity) {
        super(capacity);
        //TODO Auto-generated constructor stub

        sizes = new int[capacity];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = 1;
        }
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
        int p1 = find(v1);
        int p2 = find(v2); 
        if(p1==p2)return;
       
        if(sizes[p1] < sizes[p2]){
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        }else{
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        }
    }
    
}
