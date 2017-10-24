package fr.istic.aoc.ActiveObject.Strategy;

import java.util.List;
import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.ObservatorGeneratorAsync;
import fr.istic.aoc.ActiveObject.Subject;

public class DiffusionEstampille implements AlgoDiffusion {
	private Subject g;
	List<ObservatorGeneratorAsync> listobservator;

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public AlgoString getType() {
		// TODO Auto-generated method stub
		return AlgoString.Estampille;
	}


}
