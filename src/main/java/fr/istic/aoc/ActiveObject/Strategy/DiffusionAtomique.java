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
	public AlgoName getType() {
		// TODO Auto-generated method stub
		return AlgoName.Atomique;
	}

}
