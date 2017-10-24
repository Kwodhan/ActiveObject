package fr.istic.aoc.ActiveObject;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.Strategy.AlgoString;

public class Afficheur implements ObservatorGenerator {

	
	private Integer value;
	public Afficheur() {
		super();
		value = new Integer(0);
	}

	@Override
	public void update(GeneratorAsync generatorAsync) {
		if (generatorAsync.getAlgo().equals(AlgoString.Atomique)) {
			atomique(generatorAsync);
		} else if (generatorAsync.getAlgo().equals(AlgoString.Sequentielle)) {
			sequentielle(generatorAsync);
		} else if (generatorAsync.getAlgo().equals(AlgoString.Estampille)) {
			estampille(generatorAsync);
		}

	}

	private void atomique(GeneratorAsync generatorAsync) {

		try {		
			value = generatorAsync.getValue().get();
			System.out.println(value);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sequentielle(GeneratorAsync generatorAsync) {

	}

	private void estampille(GeneratorAsync generatorAsync) {
		try {		
			Integer temp = generatorAsync.getValue().get();
			if(!temp.equals(value)) {
				value=temp;
			}
			System.out.println(value);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}