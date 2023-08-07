package com.example.springschool.multithread;

public class RunnableLab implements Runnable {
    private int sleepTime;

    public RunnableLab(int sleppTime){
        this.sleepTime = sleppTime;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
