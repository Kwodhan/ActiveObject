package fr.istic.aoc.ActiveObject.Async;

import java.util.List;

import fr.istic.aoc.ActiveObject.Async.ObserverAsync;
import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;

public interface SubjectAsync<T> {
	
	void addObserver(ObserverAsync<T> obs);

	void removeObserver(ObserverAsync<T> obs);

	List<ObserverAsync<T>> getObserver();
	
	void setAlgoDiffusion(AlgoDiffusion algoDiffusion);
}
