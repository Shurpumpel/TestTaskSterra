package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ListData list = new ListData();

        Thread thread1 = new MyThread(true, list);
        Thread thread2 = new MyThread(false, list);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(thread1);
        System.out.println(thread2);
    }
}
