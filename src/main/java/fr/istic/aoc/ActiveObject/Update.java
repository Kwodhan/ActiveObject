package fr.istic.aoc.ActiveObject;

import java.util.concurrent.Callable;

public class Update implements Callable<Void>{
	ObservatorGenerator ObservatorGenerator;
	Canal canal;

	public Update(ObservatorGenerator observatorGenerator, Canal canal) {
		super();
		ObservatorGenerator = observatorGenerator;
		this.canal = canal;
	}

	@Override
	public Void call() throws Exception {

		ObservatorGenerator.update(canal);
		return null;

	}

	
}
