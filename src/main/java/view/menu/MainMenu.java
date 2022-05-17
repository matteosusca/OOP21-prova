package view.menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import app.MetalShot;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMenu extends StackPane {


	public MainMenu(final Stage primaryStage, final MetalShot viewRef) throws FileNotFoundException {
		final Image pressedSTRButton = new Image(new FileInputStream("src\\main\\resources\\startButtonPressed.png"));
		final Image normalSTRButton = new Image(new FileInputStream("src\\main\\resources\\startButton.png"));
		final Image normalCLSButton = new Image(new FileInputStream("src\\main\\resources\\closeButton.png"));
		final Image pressedCLSButton = new Image(new FileInputStream("src\\main\\resources\\closeButtonPressed.png"));
		final CustomButton startButton = new CustomButton();
		final CustomButton closeButton = new CustomButton();
		closeButton.updateImages(pressedCLSButton, normalCLSButton);
		startButton.updateImages(pressedSTRButton, normalSTRButton);
		this.getChildren().add(startButton);
		closeButton.setTranslateY(50);
		this.getChildren().add(closeButton);
		closeButton.setOnMouseReleased(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
				primaryStage.close();
			}

		});
		startButton.setOnMouseReleased(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
				try {
					viewRef.startGame();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

		});
	}
}
