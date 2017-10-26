package fr.istic.aoc.ActiveObject.Strategy;

public interface AlgoDiffusion {
	void configure();

	void execute();
	
	AlgoName getType();
	

	
}
