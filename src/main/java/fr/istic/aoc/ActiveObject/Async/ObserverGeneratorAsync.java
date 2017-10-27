package fr.istic.aoc.ActiveObject.Async;

import java.util.concurrent.Future;
//on observe Generator
public interface ObserverGeneratorAsync<T> {
	Future<Void> update(T generator);
	

}
