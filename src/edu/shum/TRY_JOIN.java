package edu.shum;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * not working
 */
@Deprecated
public class TRY_JOIN {

    static int a = 2;
    static volatile int b = 3;


    public static void main(String[] args) throws InterruptedException {

        AtomicReference<String> will = new AtomicReference<>("");

        while (!will.get().equals("74")) {

            Thread t1 = new Thread() {
                @Override
                public void run() {

                    a = 4;
                    b = 7;

                    System.out.println("1");
                }
            };
            Thread t2 = new Thread() {
                @Override
                public void run() {

                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int c = b;
                    int k = a;

                    will.set("" + c + k);
                    System.out.println("c=" + c + " k=" + k);
                }

            };
            t2.start();
            TimeUnit.SECONDS.sleep(1);
            t1.start();

            while (t1.isAlive() || t2.isAlive()) {

            }
        }

        System.out.println("got 7,4");


    }
}
