package fr.istic.aoc.ActiveObject;

import java.util.concurrent.Future;

import fr.istic.aoc.ActiveObject.Strategy.AlgoString;

public interface GeneratorAsync {

	Future<Integer> getValue();
	
	AlgoString getAlgo();

}
