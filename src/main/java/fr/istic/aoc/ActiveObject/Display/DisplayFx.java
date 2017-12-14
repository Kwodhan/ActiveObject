package fr.istic.aoc.ActiveObject.Display;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.ActiveObject.Async.GeneratorAsync;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class DisplayFx extends Label implements Observer<GeneratorAsync> {
	private final String name;
	private Integer value;

	public DisplayFx(String name) {
		super();
		this.name = name;
		value = new Integer(0);
	}

	@Override
	public void update(GeneratorAsync generatorAsync) {

		try {
			value = generatorAsync.getValue().get();
			Platform.runLater(() -> {
				this.setText(""+value);
				;
			});

			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String toString() {
		return this.name + " : " + value;
	}

}