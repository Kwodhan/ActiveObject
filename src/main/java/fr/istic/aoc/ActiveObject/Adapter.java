package fr.istic.aoc.ActiveObject;

import java.util.ArrayList;
import java.util.List;

import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;
import fr.istic.aoc.ActiveObject.Strategy.AlgoString;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionAtomique;

public class Adapter implements Subject {

	List<ObservatorGeneratorAsync> listobservator;

	Generator generator;

	AlgoDiffusion algoDiffusion;

	public Adapter(Generator generator) {
		super();
		this.listobservator = new ArrayList<>();
		this.generator = generator;
		algoDiffusion = new DiffusionAtomique(this);
	}

	@Override
	public Integer getValue() {

		return this.generator.getValue();
	}

	@Override
	public void generate() {
		this.generator.generate();
		this.algoDiffusion.execute();

	}

	@Override
	public void addObserver(ObservatorGeneratorAsync obs) {
		if (!listobservator.contains(obs)) {
			this.listobservator.add(obs);
		}

	}

	@Override
	public void removeObserver(ObservatorGeneratorAsync obs) {
		this.listobservator.remove(obs);

	}

	@Override
	public List<ObservatorGeneratorAsync> getObservator() {

		return this.listobservator;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}

	public AlgoString getAlgoDiffusion() {
		return algoDiffusion.getType();
	}

}
