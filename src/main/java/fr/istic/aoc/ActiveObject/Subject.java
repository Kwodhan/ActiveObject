package fr.istic.aoc.ActiveObject;

import java.util.List;

import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;
import fr.istic.aoc.ActiveObject.Strategy.AlgoName;

public interface Subject extends Generator {

	
	void addObserver(ObservatorGeneratorAsync obs);
	void removeObserver(ObservatorGeneratorAsync obs);
	List<ObservatorGeneratorAsync> getObservator();
	void setAlgoDiffusion(AlgoDiffusion algoDiffusion);
	AlgoName getAlgoDiffusion();
}
