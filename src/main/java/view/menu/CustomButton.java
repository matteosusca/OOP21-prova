package view.menu;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * 
 * 
 */
public class CustomButton extends Button {
    
    private Image selected;
    private Image unselected;
    private ImageView iv;
    
	public void updateImages(final Image selected, final Image unselected) {
	    this.selected = selected;
	    this.unselected = unselected;
        this.iv = new ImageView(unselected);
        this.getChildren().add(iv);
        this.setStyle("-fx-background-color: transparent;");
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        this.setOnMousePressed(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
				setSelectedImg();
			}
        });
        this.setOnMouseReleased(new EventHandler<>() {

			@Override
			public void handle(final MouseEvent event) {
				setUnselectedImg();
			}
        });

        super.setGraphic(iv);
    }
	
	public void setSelectedImg() {
	    this.iv.setImage(selected);
	}
	
	public void setUnselectedImg() {
        this.iv.setImage(unselected);
    }
}