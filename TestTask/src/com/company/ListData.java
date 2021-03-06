package com.company;

import java.util.LinkedList;
import java.util.Random;

public class ListData {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int SIZE = 1000;
    private final int listValuesRange = 100;

    public ListData(){
        Random random = new Random();
        for (int i = 0; i < this.SIZE; i++) {
            this.list.add(random.nextInt(this.listValuesRange));
        }
    }

    public synchronized int getFirstOrLastAndRemove(FirstOrLast firstOrLast) throws Exception {
        int value;
        if(!list.isEmpty()) {
            switch (firstOrLast) {
                case first -> {
                    value = this.list.removeFirst();
                }
                case last -> {
                    value = this.list.removeLast();
                }
                default -> throw new Exception("OnlyFirstOrLasException in List.getFirstOrLastAndRemove()");
            }
            return value;
        }else{
            return -1;
        }
    }

}
