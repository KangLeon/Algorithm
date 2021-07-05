/*
 * @Author: your name
 * @Date: 2021-07-05 13:29:12
 * @LastEditTime: 2021-07-05 15:06:07
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /2020-07-05/src/com/company/union/Unionfind.java
 */
package com.company.union;

public abstract class Unionfind {
    protected int[] parents;

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
    public abstract int find(int v);

    /**
     * @description: 合并v1、v2所在的集合
     * @param {int} v1
     * @param {int} v2
     * @return {*}
     */    
    public abstract void union(int v1,int v2);

    /**
     * @description: 检查v1、v2是否属于同一个集合
     * @param {int} v1
     * @param {int} v2
     * @return {*}
     */    
    public boolean isSame(int v1,int v2){
        return find(v1) == find(v2);
    }

    protected void rangeCheck(int v){
        if(v<0 || v >= parents.length){
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
