package com.example.live1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iter {
    // Iter <--> Observable
    // pulling <--> push
    public static void main(String[] args){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        for(Integer integer : integers){
            System.out.println(integer);
        }

        java.lang.Iterable<Integer> iter = () -> new Iterator<Integer>() {
            int i = 0;
            final static int MAX = 5;

            public boolean hasNext() {
                return i < MAX;
            }
            public Integer next() {
                return ++i;
            }
        };
        for(Integer integer : iter){
            System.out.println(integer);
        }

        for(Iterator<Integer> it = iter.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }
}
