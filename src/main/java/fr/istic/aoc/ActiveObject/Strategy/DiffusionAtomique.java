package fr.istic.aoc.ActiveObject.Strategy;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.Async.ObserverGeneratorAsync;
import fr.istic.aoc.ActiveObject.Subject.Generator;

public class DiffusionAtomique implements AlgoDiffusion {

	private final Generator generator;
	public DiffusionAtomique(Generator generator) {
		super();
		this.generator=generator;

	}

	@Override
	public void configure() {

	}

	@Override
	public void execute() {

		for (ObserverGeneratorAsync<Generator> obs : this.generator.getObserver()) {
			try {
				obs.update(this.generator).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public AlgoName getType() {
		// TODO Auto-generated method stub
		return AlgoName.Atomique;
	}

}
