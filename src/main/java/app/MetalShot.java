package app;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.stream.Collectors;

import controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import util.Direction;
import util.Vector;
import view.BulletsView;
import view.menu.MainMenu;

/**
 * TODO: write javadoc
 *
 */
public final class MetalShot extends Application {

	private Controller controller;
	private Group mainGroup;
	private BulletsView bulletsView;
	private Stage primaryStage;
	private MainMenu mainMenu;
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;

		this.mainMenu = new MainMenu(primaryStage, this);

		var s = new Scene(mainMenu, 700, 700);

		primaryStage.setScene(s);

		primaryStage.setTitle("Hello");
		primaryStage.show();
	}

	public void startGame() throws FileNotFoundException {
		this.mainMenu.setVisible(false);
		
		controller = new Controller(this);

		mainGroup = new Group();

		bulletsView = new BulletsView();
		
		primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(final KeyEvent event) {
				controller.keyPressed(event.getCode());
			}

		});

		controller.gameStart();
	}
	
	public void displayBullets(final Map<Vector, Direction> bullets) {
		this.mainGroup.getChildren().removeAll(this.bulletsView.getImageViewList());
		this.bulletsView.updateBullets(bullets.keySet().stream().collect(Collectors.toList()));
		this.mainGroup.getChildren().addAll(this.bulletsView.getImageViewList());
	}

	public static void run(final String... args) {
		launch();
	}

	/**
	 * TODO: write javadoc
	 * 
	 * @author Andrea Biagini
	 *
	 */
	public static final class Main {
		private Main() {
			// the constructor will never be called directly.
		}

		public static void main(final String... args) {
			Application.launch(MetalShot.class, args);
		}
	}
}
