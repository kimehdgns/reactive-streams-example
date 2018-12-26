package com.example.live1;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ob {
    static class IntObservable extends Observable implements Runnable{

        @Override
        public void run() {
            for(int i=1; i<=5; i++){
                setChanged();
                notifyObservers(i);
                // int i = it.next();
            }
        }
    }


    // Iter <--> Observable
    // pulling <--> push
    public static void main(String[] args) {
        // source -> event/data -> observer
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };

        IntObservable intObservable = new IntObservable();
        intObservable.addObserver(observer);
        intObservable.run();


        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(intObservable);
        System.out.println(Thread.currentThread().getName() + " : EXIT");
        es.shutdown();

        // how to notify complete ?
        // how to handle exception ?
    }
}
