package fr.istic.aoc.ActiveObject.Async;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.ActiveObject.Display.Observer;
import fr.istic.aoc.ActiveObject.Subject.Generator;
import fr.istic.aoc.ActiveObject.Subject.Subject;

public class Canal implements GeneratorAsync, ObserverAsync<Generator>, Subject<GeneratorAsync> {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

	private Generator generator;
	private Observer<GeneratorAsync> obsgenerator;
	private final Random random;
	private final int second;

	public Canal(int second) {
		super();
		random = new Random();
		this.second=second;

	}

	@Override
	public Future<Void> update(Generator generator) {
		Update update = new Update(obsgenerator, this);
		return scheduler.schedule(update,random.nextInt( second), TimeUnit.SECONDS);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
		this.generator.addObserver(this);
	}

	@Override
	public void addObserver(Observer<GeneratorAsync> obs) {
		this.obsgenerator = obs;
	}

	@Override
	public void removeObserver(Observer<GeneratorAsync> obs) {
		this.obsgenerator = null;
	}

	@Override
	public Future<Integer> getValue() {

		GetValue getValue = new GetValue(generator);

		return scheduler.schedule(getValue, random.nextInt( second), TimeUnit.SECONDS);
	}

	@Override
	public void notifyObservers() {
		this.obsgenerator.update(this);
		
	}

}
