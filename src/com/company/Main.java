package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
	final int number = 100;
	System.out.println(number + " people is deciding if they want to watch a movie...");
	ExecutorService executor = Executors.newFixedThreadPool(number);
	List<Callable<Boolean>> callables = new ArrayList<>();

	for(int i = 0; i < 100; i++) {
	    Person temp = new Person();
	    callables.add(temp);
    }

	List<Future<Boolean>> response = executor.invokeAll(callables);
    int numberOfViewers = 0;
	for (Future<Boolean> temp : response) {
		if(temp.get()) numberOfViewers++;
	}

	if(numberOfViewers < 5) {
		System.out.println(numberOfViewers + " decided they want to watch the movie.");
		System.out.println("Sorry, movie won't be played.");
		executor.shutdownNow();
		return;
	}

	System.out.println(numberOfViewers + " decided they want to watch the movie.");
	System.out.println("Movie starting...");


	sleep(2000);

	System.out.println("Half of the movie time passed.");

	executor.shutdownNow();

	executor = Executors.newFixedThreadPool(numberOfViewers);

	callables.clear();

	for (int i = 0; i < numberOfViewers ; i++) {
		Viewer temp = new Viewer();
		callables.add(temp);
	}

	response.clear();
	response = executor.invokeAll(callables);
	int viewersWillingToLeave = 0;

	for (Future<Boolean> temp : response) {
		if(temp.get()) viewersWillingToLeave++;
	}

	if(numberOfViewers - viewersWillingToLeave < 5 ) {
		System.out.println(viewersWillingToLeave + " viewers decided to leave! " + (numberOfViewers - viewersWillingToLeave) + " viewers staying!");
		System.out.println("You better return tickets money, this movie is boring!");
		executor.shutdownNow();
		return;
	}

	System.out.println(viewersWillingToLeave + " viewers decided to leave! " + (numberOfViewers - viewersWillingToLeave) + " viewers staying!");
	System.out.println("Second part of movie is starting!");
	sleep(2000);
	System.out.println("Movie time is over!");
	executor.shutdownNow();

    }

}
