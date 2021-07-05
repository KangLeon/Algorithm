/*
 * @Author: your name
 * @Date: 2021-07-05 13:29:12
 * @LastEditTime: 2021-07-05 13:54:37
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/Unionfind.java
 */
package com.company.union;

public class Unionfind {
    private int[] parents;

    public Unionfind(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Capacity must be >= 1");
        }

        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        } 
    }

    /**
     * @description: 查找v所属的集合（根节点）
     * @param v
     * @return 
     */    
    public int find(int v){
        rangeCheck(v);

        return parents[v];
    }

    private void rangeCheck(int v){
        if(v<0 || v >= parents.length){
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
