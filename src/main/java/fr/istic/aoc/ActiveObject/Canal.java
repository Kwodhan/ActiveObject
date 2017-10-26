package fr.istic.aoc.ActiveObject;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.ActiveObject.Strategy.AlgoName;

public class Canal implements GeneratorAsync, ObservatorGeneratorAsync {
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
	
	private Subject generator;
	private ObservatorGenerator obsgenerator;
	private final Random random;

	public Canal() {
		super();
		random=new Random();

	}

	@Override
	public Future<Integer> getValue() {
		
		GetValue getValue = new GetValue(generator);

		return scheduler.schedule(getValue, random.nextInt(500), TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Void> update(Generator generator) {
		Update update = new Update(obsgenerator, this);
		return scheduler.schedule(update,random.nextInt(500),TimeUnit.MILLISECONDS);
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
	public AlgoName getAlgo() {
		return this.generator.getAlgoDiffusion();
	}

}
