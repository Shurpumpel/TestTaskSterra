package com.company;


public class MyThread extends Thread{
    private int countOfCheckedValues = 0;
    private int countOfZerosOrOnes = 0;
    private ListData list;
    private FirstOrLast firstOrLast;



    public MyThread(FirstOrLast firstOrLast, ListData list) {
        this.firstOrLast = firstOrLast;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            int value;
            while ((value = list.getFirstOrLastAndRemove(
                    this.firstOrLast)) > -1) {
                this.countOfZerosOrOnes += getCountOfZerosOrOnes(value);
                countOfCheckedValues++;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private int getCountOfZerosOrOnes(int value) throws Exception {
        int count = 0;
        switch (this.firstOrLast){
            case first:
                for (int i = 0; i < 32; i++) {
                    if((value & 1) == 0)
                        count++;
                    value >>>= 1;
                }
                break;
            case last:
                for (int i = 0; i < 32; i++) {
                    if((value & 1) == 1)
                        count++;
                    value >>>= 1;
                }
                break;
            default:
                throw new Exception("Only first or last MyThread.getCountOfZerosIrOnes()");
        }
        return count;
    }


    @Override
    public String toString() {
        String out = "Thread";
        switch (this.firstOrLast) {
            case first -> out += "1:\n" +
                    "\tCount of zeros: " + this.countOfZerosOrOnes + "\n" +
                    "\tCount of checked values:" + this.countOfCheckedValues + "\n";
            case last -> out += "2\n" +
                    "\tCount of ones: " + this.countOfZerosOrOnes + "\n" +
                    "\tCount of checked values:" + this.countOfCheckedValues + "\n";
        }
        return out;
    }
}
