package fr.istic.aoc.ActiveObject.Subject;

import fr.istic.aoc.ActiveObject.Display.Observer;


public interface Subject<T>{

	void addObserver(Observer<T> obs);

	void removeObserver(Observer<T> obs);
	
	void notifyObservers();


}
