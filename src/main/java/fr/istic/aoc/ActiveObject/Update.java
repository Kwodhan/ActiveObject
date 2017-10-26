package fr.istic.aoc.ActiveObject;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {
	ObservatorGenerator observatorGenerator;
	Canal canal;

	public Update(ObservatorGenerator observatorGenerator, Canal canal) {
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
