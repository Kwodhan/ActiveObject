package fr.istic.aoc.ActiveObject.Async;

import java.util.concurrent.Callable;

import fr.istic.aoc.ActiveObject.Display.Observer;

public class Update implements Callable<Void> {
	Observer<GeneratorAsync> observatorGenerator;
	Canal canal;

	public Update(Observer<GeneratorAsync> observatorGenerator, Canal canal) {
		super();
		this.observatorGenerator = observatorGenerator;
		this.canal = canal;
	}

	@Override
	public Void call() throws Exception {

		observatorGenerator.update(canal);
		return null;

	}

}
