package fr.istic.aoc.ActiveObject.View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.ActiveObject.Async.Channel;
import fr.istic.aoc.ActiveObject.Async.GeneratorAsync;
import fr.istic.aoc.ActiveObject.Display.DisplayFx;
import fr.istic.aoc.ActiveObject.Display.Observer;
import fr.istic.aoc.ActiveObject.Strategy.AlgoDiffusion;
import fr.istic.aoc.ActiveObject.Strategy.AlgoName;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionAtomique;
import fr.istic.aoc.ActiveObject.Strategy.DiffusionSequentielle;
import fr.istic.aoc.ActiveObject.Subject.Generator;
import fr.istic.aoc.ActiveObject.Subject.GeneratorImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Window extends Application implements Initializable {


	@FXML
	RadioButton atomique;

	@FXML
	RadioButton sequentielle ;

	@FXML
	Button start;

	@FXML
	Button stop ;

	@FXML
	ListView<Label> listView;
	
	Generator generator = new GeneratorImpl();

	HashMap<AlgoName, AlgoDiffusion> dict = new HashMap<>();

	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		final ToggleGroup group = new ToggleGroup();
		atomique.setToggleGroup(group);
		atomique.setSelected(true);
		sequentielle.setToggleGroup(group);

		// liste des algos
		AlgoDiffusion atomique = new DiffusionAtomique(generator);
		AlgoDiffusion sequentielle = new DiffusionSequentielle(generator);
		dict.put(atomique.getType(),atomique);
		dict.put(sequentielle.getType(),sequentielle );


		generator.setAlgoDiffusion(dict.get(AlgoName.Atomique));

		// Observator
		Observer<GeneratorAsync> observatorGenerator1 = new DisplayFx("Afficheur1");
		Observer<GeneratorAsync> observatorGenerator2 = new DisplayFx("Afficheur2");
		Observer<GeneratorAsync> observatorGenerator3 = new DisplayFx("Afficheur3");
		Observer<GeneratorAsync> observatorGenerator4 = new DisplayFx("Afficheur4");
//		Observer<GeneratorAsync> observatorGenerator5 = new Display("Afficheur5");
//		Observer<GeneratorAsync> observatorGenerator6 = new Display("Afficheur6");

		//couplage 1
		Channel channel1 = new Channel(0);
		channel1.setGenerator(generator);
		channel1.addObserver(observatorGenerator1);

		//couplage 2
		Channel channel2 = new Channel(200);
		channel2.setGenerator(generator);
		channel2.addObserver(observatorGenerator2);

		//couplage 3
		Channel channel3 = new Channel(400);
		channel3.setGenerator(generator);
		channel3.addObserver(observatorGenerator3);

		//couplage 4
		Channel channel4 = new Channel(800);
		channel4.setGenerator(generator);
		channel4.addObserver(observatorGenerator4);

		//couplage 5
//		Channel canal5 = new Channel(1200);
//		canal5.setGenerator(generator);
//		canal5.addObserver(observatorGenerator5);
//
		//couplage 6
//		Channel canal6 = new Channel(1600);
//		canal6.setGenerator(generator);
//		canal6.addObserver(observatorGenerator6);

        List<DisplayFx> displays = new ArrayList<>();
        displays.add((DisplayFx) observatorGenerator1);
        displays.add((DisplayFx) observatorGenerator2);
        displays.add((DisplayFx) observatorGenerator3);
        displays.add((DisplayFx) observatorGenerator4);
//      displays.add((DisplayFx) observatorGenerator5);
//      displays.add((DisplayFx) observatorGenerator6);


		listView.getItems().addAll(displays);


	}




	@Override
	public void start(Stage primaryStage) {

		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		final Scene scene = new Scene(root, 350, 350);
		primaryStage.setTitle("Test de GridPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	private void onClickAtomique(ActionEvent event) {

		generator.setAlgoDiffusion(dict.get(AlgoName.Atomique));

	}

	@FXML
	private void onClickSequentielle(ActionEvent event) {

		generator.setAlgoDiffusion(dict.get(AlgoName.Sequentielle));

	}


	@FXML
	private void onClickStart(ActionEvent event) {
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
		}, 0, 1000, TimeUnit.MILLISECONDS);
		sequentielle.setDisable(true);
		atomique.setDisable(true);
	}

	@FXML
	private void onClickStop(ActionEvent event) {
		scheduler.shutdown();
		try {
			scheduler.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException interruptedException) {
			System.out.println("mrde");
		}
		scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
		sequentielle.setDisable(false);
		atomique.setDisable(false);
	}

    public static void main(String[] args) {
        launch(args);
    }







}