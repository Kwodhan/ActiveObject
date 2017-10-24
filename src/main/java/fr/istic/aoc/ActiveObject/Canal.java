package fr.istic.aoc.ActiveObject;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.ActiveObject.Strategy.AlgoString;

public class Canal implements GeneratorAsync, ObservatorGeneratorAsync {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
	private Subject generator;
	private ObservatorGenerator obsgenerator;

	public Canal() {
		super();

	}

	@Override
	public Future<Integer> getValue() {

		GetValue getValue = new GetValue(generator);
		return scheduler.schedule(getValue, 500, TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Void> update(Generator generator) {
		Update update = new Update(obsgenerator, this);
		return scheduler.schedule(update, 500, TimeUnit.MILLISECONDS);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Subject generator) {
		this.generator = generator;
	}

	public ObservatorGenerator getObsgenerator() {
		return obsgenerator;
	}

	public void setObsgenerator(ObservatorGenerator obsgenerator) {
		this.obsgenerator = obsgenerator;
	}

	@Override
	public AlgoString getAlgo() {
		return this.generator.getAlgoDiffusion();
	}

}
