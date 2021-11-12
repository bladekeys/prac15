package com.company;

public class Robot {

    private final Object monitor = new Object();

    Leg left = new Leg("LEFT",monitor);
    Leg right = new Leg("RIGHT",monitor);

    void run() {
        new Thread(left).start();
        new Thread(right).start();
    }

}