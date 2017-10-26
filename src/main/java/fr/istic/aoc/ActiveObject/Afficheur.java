package fr.istic.aoc.ActiveObject;

import java.util.concurrent.ExecutionException;

public class Afficheur implements ObservatorGenerator {
	private final String name;
	private Integer value;

	public Afficheur(String name) {
		super();
		this.name = name;
		value = new Integer(0);
	}

	@Override
	public void update(GeneratorAsync generatorAsync) {

		try {
			value = generatorAsync.getValue().get();
			System.out.println(this);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String toString() {
		return this.name+" : "+value;
	}

}