package com.java8.examples;

import java.util.LinkedList;

public class ProducerConsumerDemo {

    public static void main(String[] args) throws InterruptedException {

        final Pc pc = new Pc();

        //producer items
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    pc.producer();
                }catch (InterruptedException e){
                    throw  new RuntimeException(e);
                }
            }
        });


        //consumes items

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });



        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static class Pc{

        private LinkedList<Integer> list = new LinkedList<>();
        private int cacpacity = 2;


        public void producer() throws InterruptedException {
            int value = 0;
            while(true){
                synchronized (this){
                    while (list.size() == cacpacity)
                        wait();

                    System.out.println("Producer produced-"+ value);

                    // to insert the jobs in the list
                    list.add(value++);

                    //notify
                    notify();

                    Thread.sleep(1000);
                }
            }
        }


        public void consume() throws InterruptedException {

            while (true){
                synchronized (this){
                    while (list.size() == 0)
                        wait();

                    // to retrieve the first job in the list
                    int val = list.removeFirst();

                    System.out.println("Consumer consumed-"+ val);
                }
            }
        }



    }

}
