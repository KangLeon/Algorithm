/*
 * @Author: your name
 * @Date: 2021-07-06 11:13:45
 * @LastEditTime: 2021-07-06 11:29:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/UnionFind_QF_R.java
 */
package com.company.union;

public class UnionFind_QF_R extends Unionfind {

    private int[] rank;

    public UnionFind_QF_R(int capacity) {
        super(capacity);
        //TODO Auto-generated constructor stub

        rank = new int[capacity];

        for (int i = 0; i < rank.length; i++) {
            rank[i] = 1;
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

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2); 
        if(p1==p2)return;

        if(rank[p1] < rank[p2]){
            parents[p1] = p2;
        }else if(rank[p1] > rank[p2]){
            parents[p2] = p1;
        }else{
            parents[p1] = p2;
            rank[p2]++;
        }
    }
}
