package com.company;


public class MyThread extends Thread{
    private final boolean isStartFromBegin;
    private int countOfCheckedValues = 0;
    private int countOfZerosOrOnes = 0;
    private ListData list;



    public MyThread(boolean isStartFromBegin, ListData list) {
        this.isStartFromBegin = isStartFromBegin;
        this.list = list;
    }

    @Override
    public void run() {
        if(isStartFromBegin)
            this.firstThreadWork();
        else
            this.secondThreadWork();
    }

    private void firstThreadWork(){
        while(list.isListNotNull()) {
            String binaryString = Integer.toBinaryString(list.getFirstAndRemove());
            this.countOfZerosOrOnes += getCountOfZerosOrOnes(binaryString, true);
            countOfCheckedValues++;
        }
    }

    private void secondThreadWork(){
        while(list.isListNotNull()){
            String binaryString = Integer.toBinaryString(list.getLastAndRemove());
            this.countOfZerosOrOnes += getCountOfZerosOrOnes(binaryString, false);
            countOfCheckedValues++;
        }
    }

    private int getCountOfZerosOrOnes(String binaryString, boolean isSearchingZeros){
        char goodValue;
        if(isSearchingZeros)
            goodValue = '0';
        else
            goodValue = '1';

        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i) == goodValue)
                count++;
        }

        return count;
    }


    @Override
    public String toString() {
        String out = "Thread";
        if(this.isStartFromBegin){
            out+="1:\n" +
                    "\tCount of zeros: " + this.countOfZerosOrOnes+"\n" +
                    "\tCount of checked values:" + this.countOfCheckedValues+"\n";
        }
        else {
            out += "2\n" +
                    "\tCount of ones: " + this.countOfZerosOrOnes + "\n" +
                    "\tCount of checked values:" + this.countOfCheckedValues + "\n";
        }
        return out;
    }
}
