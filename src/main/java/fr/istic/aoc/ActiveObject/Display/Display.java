package fr.istic.aoc.ActiveObject.Display;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.Async.GeneratorAsync;

public class Display implements Observer<GeneratorAsync> {
	private final String name;
	private Integer value;

	public Display(String name) {
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