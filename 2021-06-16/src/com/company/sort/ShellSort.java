package com.company.sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSquence();
        for(Integer step : stepSequence){

        }
    }

    /*
    * 分成step列进行排序
    * @param step
    * */
    private void sort(int step){

    }
    
    private List<Integer> shellStepSquence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;

        while ((step >>= 1) > 0){
            stepSequence.add(step);
        }
        return stepSequence;
    }

    private List<Integer> myStepSequence() {

    }
}
