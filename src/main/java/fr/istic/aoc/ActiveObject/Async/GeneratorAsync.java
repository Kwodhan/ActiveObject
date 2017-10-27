package fr.istic.aoc.ActiveObject.Async;

import java.util.concurrent.Future;



public interface GeneratorAsync {

	Future<Integer> getValue();


}
