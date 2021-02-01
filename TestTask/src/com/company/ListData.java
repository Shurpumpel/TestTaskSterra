package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListData {
    private List<Integer> list = new LinkedList<>();
    private int size = 1000;

    public ListData(){
        Random random = new Random();
        for (int i = 0; i < this.size; i++) {
            this.list.add(random.nextInt(100));
        }
    }

    public synchronized boolean isListNotNull(){
        return size > 0;
    }

    public int getFirstAndRemove(){
        return this.getFirstOrLastAndRemove(true);
    }

    public int getLastAndRemove(){
        return this.getFirstOrLastAndRemove(false);
    }

    private synchronized int getFirstOrLastAndRemove(boolean isGettingFirst){
        int value = -1;
        if(isGettingFirst) {
            value = list.get(0);
            this.list.remove(0);
        }else{
            value = list.get(size - 1);
            this.list.remove(size - 1);
        }
        this.size--;
        return value;
    }

}
