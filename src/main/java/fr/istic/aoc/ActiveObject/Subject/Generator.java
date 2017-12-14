package fr.istic.aoc.ActiveObject.Subject;

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
