package fr.istic.aoc.ActiveObject.Strategy;

import fr.istic.aoc.ActiveObject.ObservatorGeneratorAsync;
import fr.istic.aoc.ActiveObject.Subject;

public class DiffusionSequentielle implements AlgoDiffusion {
	private Subject g;

	public DiffusionSequentielle(Subject g) {
		super();
		this.g = g;

	}

	@Override
	public void configure() {

	}

	@Override
	public void execute() {

		for (ObservatorGeneratorAsync obs : g.getObservator()) {

			obs.update(g);

		}
	}

	@Override
	public AlgoName getType() {

		return AlgoName.Sequentielle;
	}

}
