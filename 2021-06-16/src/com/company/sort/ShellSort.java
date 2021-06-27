package com.company.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSquence();
        for(Integer step : stepSequence){
            sort(step);
        }
    }

    /*
    * 分成step列进行排序
    * @param step
    * */
    private void sort(int step){
        //col：第几列，column的简称
        for (int col = 0; col < step; col++) {//对第col列进行排序
            //col、col+step，col+2*step、col+3*step
            for (int begin = col + step; begin < array.length; begin+=step) {
                int cur = begin;
                while (cur > col && cmp(cur,cur-step) < 0){
                    swap(cur,cur-step);
                    cur -= step;
                }
            }
        }
    }

    protected void swap(int v1,int v2){
        int tmp = v1;
        v1 = v2;
        v2 = tmp;
    }


    //希尔提供的确定步长序列
    private List<Integer> shellStepSquence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;

        while ((step >>= 1) > 0){
            stepSequence.add(step);
        }
        return stepSequence;
    }

    //另外一个科学家提供的确定步长序列
    private List<Integer> myStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0,step = 0;
        while (true){
            if ( k % 2 == 0){
                int pow = (int)Math.pow(2,k>>1);
                step = 1 + 9*(pow*pow - pow);
            }else {
                int pow1 = (int)Math.pow(2,(k-1)>>1);
                int pow2 = (int)Math.pow(2,(k+1)>>1);
                step = 1 + 8*pow1*pow2 - 6 *pow2;
            }
            if (step >= array.length) break;
            stepSequence.add(0,step);
            k++;
        }
        return stepSequence;
    }
}
