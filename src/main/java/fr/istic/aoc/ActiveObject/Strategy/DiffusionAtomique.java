package fr.istic.aoc.ActiveObject.Strategy;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.ObservatorGeneratorAsync;
import fr.istic.aoc.ActiveObject.Subject;

public class DiffusionAtomique implements AlgoDiffusion {
	private Subject g;


	public DiffusionAtomique(Subject g) {
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
		// attendre que tous le monde ai fini
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
		return AlgoString.Atomique;
	}

}
