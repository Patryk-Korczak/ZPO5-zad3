package com.company;
import java.util.Random;
import java.util.concurrent.Callable;

public class Viewer implements Callable {
    private int probability = 30;
    private Boolean decision = false;

    public Viewer() {

    }

    public Boolean decide() {
        Random generator = new Random();
        if(generator.nextInt(100) < probability) decision = true;
        return decision;
    }



    @Override
    public Boolean call() {
        return decide();
    }
}