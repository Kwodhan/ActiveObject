package fr.istic.aoc.ActiveObject.Subject;

import java.util.ArrayList;
import java.util.List;

import fr.istic.aoc.ActiveObject.Async.ObserverAsync;
import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionAtomique;

public class GeneratorImpl implements Generator {

	private Integer value;

	private AlgoDiffusion algoDiffusion;

	List<ObserverAsync<Generator>> list;

	public GeneratorImpl() {
		super();
		value = new Integer(0);
		list = new ArrayList<>();
		algoDiffusion = new DiffusionAtomique(this);
	}

	@Override
	public Integer getValue() {
		return value;

	}

	@Override
	public void generate() {
		++value;
		notifyObservers();
	}

	private void notifyObservers() {

		this.algoDiffusion.execute();

	}

	public void addObserver(ObserverAsync<Generator> obs) {
		this.list.add(obs);

	}

	public void removeObserver(ObserverAsync<Generator> obs) {
		this.list.remove(obs);

	}

	@Override
	public List<ObserverAsync<Generator>> getObserver() {
		// TODO Auto-generated method stub
		return this.list;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}

}
