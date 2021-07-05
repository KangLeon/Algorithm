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
     * @description: 
     * @param {*}
     * @return {*}
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
