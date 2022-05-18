package view.menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import app.MetalShot;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import util.UserData;
/**
 * 
 * 
 */
public class MainMenu extends StackPane {

    private final MetalShot viewRef;
    private SignIn signInScreen = new SignIn(this);
    private final CustomButton startButton = new CustomButton();
    private final CustomButton closeButton = new CustomButton();
    private final CustomButton optionButton = new CustomButton();
    
	public MainMenu(final MetalShot viewRef) throws FileNotFoundException {
	    this.viewRef = viewRef;
		final Image pressedSTRButton = new Image(new FileInputStream("src\\main\\resources\\startButtonPressed.png"));
		final Image normalSTRButton = new Image(new FileInputStream("src\\main\\resources\\startButton.png"));
		final Image normalCLSButton = new Image(new FileInputStream("src\\main\\resources\\closeButton.png"));
		final Image pressedCLSButton = new Image(new FileInputStream("src\\main\\resources\\closeButtonPressed.png"));
        final Image normalOPTButton = new Image(new FileInputStream("src\\main\\resources\\optionButton.png"));
        final Image pressedOPTButton = new Image(new FileInputStream("src\\main\\resources\\optionButtonPressed.png"));
		
		optionButton.updateImages(pressedOPTButton, normalOPTButton);
		closeButton.updateImages(pressedCLSButton, normalCLSButton);
		startButton.updateImages(pressedSTRButton, normalSTRButton);
		this.getChildren().add(startButton);
		optionButton.setTranslateY(70);
		this.getChildren().add(optionButton);
		closeButton.setTranslateY(140);
		this.getChildren().add(closeButton);
		closeButton.setOnMouseReleased(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
				viewRef.getStage().close();
			}

		});
		startButton.setOnMouseReleased(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
			    viewRef.getMainScene().setRoot(signInScreen);
			}

		});
		optionButton.setOnMouseReleased(new EventHandler<>() {

            @Override
            public void handle(final MouseEvent event) {
                viewRef.getMainScene().setRoot(new Group());
            }
		});
	}
	
	public void returnToMM() {
	    this.startButton.setUnselectedImg();
	    this.viewRef.getMainScene().setRoot(this);
	}
	
	public UserData getUserData() {
	    return this.signInScreen.getUserData();
	}
	
	public void startGame() throws FileNotFoundException {
	    viewRef.startGame();
	}
}
