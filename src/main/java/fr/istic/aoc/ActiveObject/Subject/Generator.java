package fr.istic.aoc.ActiveObject.Subject;

import java.util.List;

import fr.istic.aoc.ActiveObject.Async.ObserverGeneratorAsync;

/**
 * SujetF
 * 
 * @author aferey
 *
 */
public interface Generator {

	Integer getValue();

	void generate();

	void addObserver(ObserverGeneratorAsync<Generator> obs);

	void removeObserver(ObserverGeneratorAsync<Generator> obs);
	
	List<ObserverGeneratorAsync<Generator>> getObserver();
}
