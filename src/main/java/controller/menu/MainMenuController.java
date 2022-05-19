package controller.menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 
 */
public class MainMenuController {

    @FXML
    private Button button;
    @FXML
    private ImageView imageView;

    @FXML
    public void prova(final MouseEvent event) throws FileNotFoundException {
        imageView.setImage(new Image(new FileInputStream("src/main/resources/startButtonPressed.png")));
    }
    
    @FXML
    public void riprova(final MouseEvent event) throws FileNotFoundException {
        imageView.setImage(new Image(new FileInputStream("src/main/resources/startButton.png")));
    }
}
