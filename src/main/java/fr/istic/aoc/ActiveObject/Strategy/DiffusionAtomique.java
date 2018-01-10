package fr.istic.aoc.ActiveObject.Strategy;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.Async.ObserverAsync;
import fr.istic.aoc.ActiveObject.Subject.Generator;

/**
 * le sujet ne peut evoluer que lorsque tous les observateurs ont lu la dernière valeurs.
 * lecteur/redacteur
 */
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

		for (ObserverAsync<Generator> obs : this.generator.getObserver()) {
			try {
				obs.update(this.generator).get();
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public AlgoName getType() {

		return AlgoName.Atomique;
	}

}
