package fr.istic.aoc.ActiveObject.Strategy;

import java.util.List;

import fr.istic.aoc.ActiveObject.ObservatorGeneratorAsync;
import fr.istic.aoc.ActiveObject.Subject;

public class DiffusionSequentielle implements AlgoDiffusion {
	private Subject g;
	List<ObservatorGeneratorAsync> listobservator;

	public DiffusionSequentielle(Subject g) {
		super();
		this.g = g;
//		flags = new ArrayList<>();
	}

	@Override
	public void configure() {
//		for (ObservatorGeneratorAsync obs : g.getObservator()) {
//			flags.add(false);
//		}

	}

	@Override
	public void execute() {

		for (ObservatorGeneratorAsync obs : g.getObservator()) {

			
				obs.update(g);
			
		}
	}

	@Override
	public AlgoString getType() {
		// TODO Auto-generated method stub
		return AlgoString.Sequentielle;
	}


}
