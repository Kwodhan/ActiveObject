package fr.istic.aoc.ActiveObject.Subject;

import fr.istic.aoc.ActiveObject.Async.SubjectAsync;

/**
 * SujetF
 * 
 * @author aferey
 *
 */
public interface Generator extends SubjectAsync<Generator> {

	Integer getValue();

	void generate();

	

}
