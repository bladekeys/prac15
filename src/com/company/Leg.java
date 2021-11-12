package com.company;
class Leg implements Runnable {
    private final String name;
    private Object monitor;
    Leg(String name,Object monitor) {
        this.name = name;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                step();
                monitor.notify();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void step() {
        System.out.println(name);
    }
}