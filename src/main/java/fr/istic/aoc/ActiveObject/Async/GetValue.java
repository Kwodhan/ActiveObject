package fr.istic.aoc.ActiveObject.Async;

import java.util.concurrent.Callable;

import fr.istic.aoc.ActiveObject.Subject.Generator;

public class GetValue implements Callable<Integer> {

	Generator generator;

	@Override
	public Integer call() throws Exception {

		return generator.getValue();
	}

	public GetValue(Generator generator) {
		this.generator = generator;
	}

}
