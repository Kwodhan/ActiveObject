package fr.istic.aoc.ActiveObject.Async;

import java.util.concurrent.Future;
//on observe Generator
public interface ObserverAsync<T> {
	Future<Void> update(T generator);
	

}
