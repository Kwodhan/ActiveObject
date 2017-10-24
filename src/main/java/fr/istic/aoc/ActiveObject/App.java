package fr.istic.aoc.ActiveObject;

import java.util.HashMap;

import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;
import fr.istic.aoc.ActiveObject.Strategy.AlgoString;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionAtomique;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionEstampille;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionSequentielle;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Subject generator = new Adapter(new GeneratorImpl());
		HashMap<AlgoString, AlgoDiffusion> dict = new HashMap<>();

		dict.put(AlgoString.Atomique, new DiffusionAtomique(generator));
		dict.put(AlgoString.Sequentielle, new DiffusionSequentielle(generator));
		dict.put(AlgoString.Estampille, new DiffusionEstampille(generator));

		ObservatorGenerator observatorGenerator1 = new Afficheur();
		ObservatorGenerator observatorGenerator2 = new Afficheur();
		ObservatorGenerator observatorGenerator3 = new Afficheur();
		ObservatorGenerator observatorGenerator4 = new Afficheur();

		Canal canal1 = new Canal();
		Canal canal2 = new Canal();
		Canal canal3 = new Canal();
		Canal canal4 = new Canal();

		canal1.setGenerator(generator);
		canal1.setObsgenerator(observatorGenerator1);
		generator.addObserver(canal1);

		canal2.setGenerator(generator);
		canal2.setObsgenerator(observatorGenerator2);
		generator.addObserver(canal2);

		canal3.setGenerator(generator);
		canal3.setObsgenerator(observatorGenerator3);
		generator.addObserver(canal3);

		canal4.setGenerator(generator);
		canal4.setObsgenerator(observatorGenerator4);
		generator.addObserver(canal4);

		generator.setAlgoDiffusion(dict.get(AlgoString.Estampille));
		generator.generate();
		generator.generate();
		generator.generate();
		generator.generate();

		//
		//
		// generator.generate();
		// generator.generate();

	}
}
