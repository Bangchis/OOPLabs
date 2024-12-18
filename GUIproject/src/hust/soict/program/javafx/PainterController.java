package hust.soict.program.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {
	
	private boolean color;
	
	@FXML
    private ToggleGroup identity;
	
	@FXML
	void chooseOption(ActionEvent event) {
		String button = ((RadioButton)event.getSource()).getText();
		if (button.equals("Pen")) {
			
			color = true;
		}else {
			
			color = false;
		}
	}
	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (color && event.getX()>=0) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4.0, Color.BLACK);
    		drawingAreaPane.getChildren().add(newCircle);
    	}else if( event.getX()>=0){
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4.0, Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
    	}
    }

}