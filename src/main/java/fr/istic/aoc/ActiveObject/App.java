package fr.istic.aoc.ActiveObject;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;
import fr.istic.aoc.ActiveObject.Strategy.AlgoName;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionAtomique;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionEstampille;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionSequentielle;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// creer generateur
		// attache canal comme observeur
		// attache afficheur sur canal

		// balance des .generate()
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

		Subject generator = new Adapter(new GeneratorImpl());
		HashMap<AlgoName, AlgoDiffusion> dict = new HashMap<>();

		dict.put(AlgoName.Atomique, new DiffusionAtomique(generator));
		dict.put(AlgoName.Sequentielle, new DiffusionSequentielle(generator));
		dict.put(AlgoName.Estampille, new DiffusionEstampille(generator));


		ObservatorGenerator observatorGenerator1 = new Afficheur("Afficheur1");
		ObservatorGenerator observatorGenerator2 = new Afficheur("Afficheur2");
		ObservatorGenerator observatorGenerator3 = new Afficheur("Afficheur3");
		ObservatorGenerator observatorGenerator4 = new Afficheur("Afficheur4");

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

		generator.setAlgoDiffusion(dict.get(AlgoName.Sequentielle));

		
			scheduler.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					generator.generate();
					
				}
			}, 0, 100, TimeUnit.MILLISECONDS);
		
		
			
	}
}
