package edu.shum;

import java.util.concurrent.atomic.AtomicReference;

public class TRY72_AMD {

    static int a = 2;
    static volatile int b = 3;


    public static void main(String[] args) {

        /**
         Проверка что все из перечисленных комбинаций возможны.
         3,2
         3,4
         7,2
         7,4
         **/

        AtomicReference<String> will = new AtomicReference<>("");

        while (!will.get().equals("72")) {

            Thread t1 = new Thread() {
                @Override
                public void run() {

                    a = 4;
                    b = 7;

                }
            };
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    int c = b;
                    int k = a;

                    will.set("" + c + k);
                }

            };
            t1.start();
            t2.start();
            while (t1.isAlive() || t2.isAlive()) {

            }
        }

        System.out.println("got 7,2");


    }
}
