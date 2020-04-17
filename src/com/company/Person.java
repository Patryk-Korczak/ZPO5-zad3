package com.company;
import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class Person implements Callable {
    private int probability = 5;
    private Boolean decision = false;

    public Person() {

    }

    public Boolean decide() {
        Random generator = new Random();
        try {
            sleep((generator.nextInt(4) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(generator.nextInt(100) < probability) decision = true;

        return decision;
    }

    @Override
    public Boolean call() throws Exception {
        return decide();
    }
}
