package fr.istic.aoc.ActiveObject;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.ActiveObject.Async.Canal;
import fr.istic.aoc.ActiveObject.Async.GeneratorAsync;
import fr.istic.aoc.ActiveObject.Display.Display;
import fr.istic.aoc.ActiveObject.Display.Observer;
import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;
import fr.istic.aoc.ActiveObject.Strategy.AlgoName;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionAtomique;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionSequentielle;
import fr.istic.aoc.ActiveObject.Subject.Generator;
import fr.istic.aoc.ActiveObject.Subject.GeneratorImpl;

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

		Generator generator = new GeneratorImpl();


		HashMap<AlgoName, AlgoDiffusion> dict = new HashMap<>();

		dict.put(AlgoName.Atomique, new DiffusionAtomique(generator));
		dict.put(AlgoName.Sequentielle, new DiffusionSequentielle(generator));

		
		Observer<GeneratorAsync> observatorGenerator1 = new Display("Afficheur1");
		Observer<GeneratorAsync> observatorGenerator2 = new Display("Afficheur2");
		Observer<GeneratorAsync> observatorGenerator3 = new Display("Afficheur3");
		Observer<GeneratorAsync> observatorGenerator4 = new Display("Afficheur4");

		

		Canal canal1 = new Canal();
		canal1.setGenerator(generator);
		canal1.addObserver(observatorGenerator1);
		
		Canal canal2 = new Canal();
		canal2.setGenerator(generator);
		canal2.addObserver(observatorGenerator2);
		
		Canal canal3 = new Canal();
		canal3.setGenerator(generator);
		canal3.addObserver(observatorGenerator3);
		
		Canal canal4 = new Canal();
		canal4.setGenerator(generator);
		canal4.addObserver(observatorGenerator4);


		
			scheduler.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					generator.generate();
					
				}
			}, 0, 100, TimeUnit.MILLISECONDS);
		
		
			
	}
}
