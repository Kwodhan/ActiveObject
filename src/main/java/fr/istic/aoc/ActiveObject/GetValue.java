package fr.istic.aoc.ActiveObject;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

	Generator generator;

	@Override
	public Integer call() throws Exception {

		return generator.getValue();
	}

	public GetValue(Generator generator) {
		super();
		this.generator = generator;
	}

}
