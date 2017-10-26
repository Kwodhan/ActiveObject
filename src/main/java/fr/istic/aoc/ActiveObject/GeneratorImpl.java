package fr.istic.aoc.ActiveObject;

public class GeneratorImpl implements Generator {

	private Integer value;

	public GeneratorImpl() {
		super();
		value = new Integer(0);

	}

	@Override
	public Integer getValue() {
		return value;
		
	}

	@Override
	public void generate() {
		++value;
	}
}
