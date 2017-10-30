package fr.istic.aoc.ActiveObject.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Window extends Application {

	List<Display> displays = new ArrayList<>();

	Generator generator = new GeneratorImpl();

	HashMap<AlgoName, AlgoDiffusion> dict = new HashMap<>();

	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

	@Override
	public void init() throws Exception {

		super.init();

		dict.put(AlgoName.Atomique, new DiffusionAtomique(generator));
		dict.put(AlgoName.Sequentielle, new DiffusionSequentielle(generator));
		generator.setAlgoDiffusion(dict.get(AlgoName.Atomique));
		Observer<GeneratorAsync> observatorGenerator1 = new Display("Afficheur1");
		Observer<GeneratorAsync> observatorGenerator2 = new Display("Afficheur2");
		Observer<GeneratorAsync> observatorGenerator3 = new Display("Afficheur3");
		Observer<GeneratorAsync> observatorGenerator4 = new Display("Afficheur4");
		Observer<GeneratorAsync> observatorGenerator5 = new Display("Afficheur5");
		Observer<GeneratorAsync> observatorGenerator6 = new Display("Afficheur6");
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
		
		Canal canal5 = new Canal();
		canal5.setGenerator(generator);
		canal5.addObserver(observatorGenerator5);
		
		Canal canal6 = new Canal();
		canal6.setGenerator(generator);
		canal6.addObserver(observatorGenerator6);

		this.addDisplay(observatorGenerator1);
		this.addDisplay(observatorGenerator2);
		this.addDisplay(observatorGenerator3);
		this.addDisplay(observatorGenerator4);
		this.addDisplay(observatorGenerator5);
		this.addDisplay(observatorGenerator6);
	

	}

	@Override
	public void start(Stage primaryStage) {
		final Button button1 = new Button("Atomique");
		final Button button2 = new Button("Sequentielle");
		final Button button3 = new Button("Start");
		final Button button4 = new Button("Stop");
		GridPane.setConstraints(button1, 0, 0);
		GridPane.setConstraints(button2, 1, 0);
		GridPane.setConstraints(button3, 0, 1);
		GridPane.setConstraints(button4, 1, 1);
		// final Region region = new Region();
		// GridPane.setConstraints(region, 0, 0, 1, Integer.MAX_VALUE);
		// region.setStyle("-fx-background-color: gold; -fx-border-color: goldenrod;");
		// region.setPrefSize(100, 100);

		final GridPane root = new GridPane();
		root.getRowConstraints().setAll(new RowConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
				new RowConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
		//
		root.getRowConstraints().get(0).setVgrow(Priority.ALWAYS);
		root.getRowConstraints().get(1).setVgrow(Priority.ALWAYS);
		root.getColumnConstraints()
				.setAll(new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
		root.getColumnConstraints().get(0).setHgrow(Priority.ALWAYS);

		// Liste afficheur
		final GridPane afficheur = new GridPane();
		afficheur.getColumnConstraints().setAll(
				new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
				new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
		afficheur.getColumnConstraints().get(0).setHgrow(Priority.ALWAYS);
		afficheur.getColumnConstraints().get(1).setHgrow(Priority.ALWAYS);
		//
		for (int i = 0; i < this.displays.size(); i++) {
			afficheur.getRowConstraints()
					.add(new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
			afficheur.getRowConstraints().get(i).setVgrow(Priority.NEVER);
			afficheur.add(this.displays.get(i), 1, i);
			afficheur.add(new Label("Afficheur " + i), 0, i);
			// afficheur.add(this.labels.get(i), 0, i);

		}
		//
		// ControlPanel
		final GridPane controlPanel = new GridPane();
		controlPanel.getColumnConstraints().setAll(
				new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
				new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
		controlPanel.getColumnConstraints().get(0).setHgrow(Priority.ALWAYS);
		controlPanel.getColumnConstraints().get(1).setHgrow(Priority.ALWAYS);
		//
		controlPanel.getRowConstraints().setAll(
				new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
				new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),
				new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
		controlPanel.getRowConstraints().get(0).setVgrow(Priority.NEVER);
		controlPanel.getRowConstraints().get(1).setVgrow(Priority.NEVER);
		controlPanel.getChildren().setAll(button1, button2,button3,button4);

		//
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				scheduler.shutdown();
				try {
					scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				} catch (InterruptedException interruptedException) {

				}
				scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
				generator.setAlgoDiffusion(dict.get(AlgoName.Atomique));

				scheduler.scheduleAtFixedRate(new Runnable() {

					@Override
					public void run() {
						generator.generate();

					}
				}, 0, 100, TimeUnit.MILLISECONDS);
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				scheduler.shutdown();
				try {
					scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				} catch (InterruptedException interruptedException) {

				}
				scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
				generator.setAlgoDiffusion(dict.get(AlgoName.Sequentielle));
				scheduler.scheduleAtFixedRate(new Runnable() {

					@Override
					public void run() {
						generator.generate();

					}
				}, 0, 100, TimeUnit.MILLISECONDS);
			}
		});
		button3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				scheduler.shutdown();
				try {
					scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				} catch (InterruptedException interruptedException) {

				}
				scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
			
				scheduler.scheduleAtFixedRate(new Runnable() {

					@Override
					public void run() {
						generator.generate();

					}
				}, 0, 100, TimeUnit.MILLISECONDS);
			}
		});
		button4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				scheduler.shutdown();
				try {
					scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				} catch (InterruptedException interruptedException) {
					System.out.println("mrde");
				}
				scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

			}
		});
		root.add(afficheur, 0, 0);
		root.add(controlPanel, 0, 1);
		afficheur.setGridLinesVisible(true);
		controlPanel.setGridLinesVisible(true);
		root.setGridLinesVisible(true);
		final Scene scene = new Scene(root, 350, 300);
		primaryStage.setTitle("Test de GridPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void addDisplay(Observer<GeneratorAsync> display) {
		this.displays.add((Display) display);

	}

	public static void main(String[] args) {

		launch(args);
	}
}