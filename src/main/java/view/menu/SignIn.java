package view.menu;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
/**
 * 
 * 
 */
public class SignIn extends StackPane {

    public SignIn(final MainMenu mm) {
        final Label label = new Label("Choose your name:");
        final TextField txtF = new TextField();
        final CustomButton button = new CustomButton();
        final CustomButton backButton = new CustomButton();
        button.setText("Inserisci");
        backButton.setText("Indietro");
        super.getChildren().add(label);
        super.getChildren().add(txtF);
        super.getChildren().add(button);
        super.getChildren().add(backButton);
        label.setTranslateY(-100);
        button.setTranslateY(100);
        backButton.setTranslateY(300);
        button.setOnMouseReleased(new EventHandler<>() {

            @Override
            public void handle(final MouseEvent event) {
                if (txtF.getText() == "") {
                    System.out.println("Non fare il pirla");
                } else {
                    System.out.println(txtF.getText());
                }
            }
        });
        backButton.setOnMouseReleased(new EventHandler<>() {

            @Override
            public void handle(final MouseEvent event) {
                mm.returnToMM();
            }
        });
    }
}
