package fr.istic.aoc.ActiveObject.Strategy;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.ObservatorGeneratorAsync;
import fr.istic.aoc.ActiveObject.Subject;

public class DiffusionEstampille implements AlgoDiffusion {
	private Subject g;

	public DiffusionEstampille(Subject g) {
		super();
		this.g = g;

	}

	@Override
	public void configure() {

	}

	@Override
	public void execute() {

		for (ObservatorGeneratorAsync obs : g.getObservator()) {

			try {
				obs.update(g).get();
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public AlgoName getType() {

		return AlgoName.Estampille;
	}

}
