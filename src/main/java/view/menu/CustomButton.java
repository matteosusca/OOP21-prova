package view.menu;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CustomButton extends Button {
	public void updateImages(final Image selected, final Image unselected) {
        final ImageView iv = new ImageView(unselected);
        this.getChildren().add(iv);
        this.setStyle("-fx-background-color: transparent;");
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        
        this.setOnMousePressed(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
				iv.setImage(selected);
				
			}
        	
        });
        
        this.setOnMouseReleased(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
				iv.setImage(unselected);
			}
        	
        });

        super.setGraphic(iv);
    }
}