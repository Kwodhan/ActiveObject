package fr.istic.aoc.ActiveObject.Async;

import java.util.concurrent.Callable;

import fr.istic.aoc.ActiveObject.Subject.Subject;

public class Update implements Callable<Void> {


	Subject subject;
	

	public Update(Subject subjet) {
		super();
		this.subject  = subjet;
	}

	@Override
	public Void call() throws Exception {
		subject.notifyObservers();
		return null;

	}

}
