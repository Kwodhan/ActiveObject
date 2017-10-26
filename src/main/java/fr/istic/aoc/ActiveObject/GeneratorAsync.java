package fr.istic.aoc.ActiveObject;

import java.util.concurrent.Future;

import fr.istic.aoc.ActiveObject.Strategy.AlgoName;

public interface GeneratorAsync {

	Future<Integer> getValue();
	
	AlgoName getAlgo();

}
