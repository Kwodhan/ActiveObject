package fr.istic.aoc.ActiveObject.Async;

import java.util.concurrent.Future;


public interface ObserverAsync<T> {
	Future<Void> update(T generator);
	

}
