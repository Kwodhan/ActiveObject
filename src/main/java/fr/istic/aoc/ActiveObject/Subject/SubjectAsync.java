package fr.istic.aoc.ActiveObject.Subject;

import java.util.List;

import fr.istic.aoc.ActiveObject.Async.ObserverAsync;

public interface SubjectAsync<T> {
	void addObserver(ObserverAsync<T> obs);

	void removeObserver(ObserverAsync<T> obs);

	List<ObserverAsync<T>> getObserver();
}
