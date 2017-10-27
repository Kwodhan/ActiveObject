package fr.istic.aoc.ActiveObject.Strategy;

import fr.istic.aoc.ActiveObject.Async.ObserverGeneratorAsync;
import fr.istic.aoc.ActiveObject.Subject.Generator;

public class DiffusionSequentielle implements AlgoDiffusion {
	private final Generator generator;

	public DiffusionSequentielle(Generator generator) {
		super();
		this.generator = generator;

	}

	@Override
	public void configure() {

	}

	@Override
	public void execute() {

		for (ObserverGeneratorAsync<Generator> obs : generator.getObserver()) {

			obs.update(generator);

		}
	}

	@Override
	public AlgoName getType() {

		return AlgoName.Sequentielle;
	}

}
