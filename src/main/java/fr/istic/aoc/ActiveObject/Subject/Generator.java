package fr.istic.aoc.ActiveObject.Subject;

import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;

/**
 * SujetF
 * 
 * @author aferey
 *
 */
public interface Generator extends SubjectAsync<Generator> {

	Integer getValue();

	void generate();

	void setAlgoDiffusion(AlgoDiffusion algoDiffusion);

}
