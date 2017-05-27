package application.FX_SampleFiles;

import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KnifeSwing extends Application{
	ImageView knifeCanvas;
	Image knife;
	Timeline swing, swingBack;
	SequentialTransition fullAnimation = new SequentialTransition();
	
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		swing = new Timeline(new KeyFrame(Duration.millis(150), new SwingHandler()));
		swing.setCycleCount(2);
		swingBack = new Timeline(new KeyFrame(Duration.millis(150), new SwingBackHandler()));
		swingBack.setCycleCount(2);
		
		fullAnimation.getChildren().addAll(swing, swingBack);
		fullAnimation.setCycleCount(1);
		
		knife = new Image("Image/knife.png");
		knifeCanvas = new ImageView(knife);
		
		knifeCanvas.setFitWidth(30);
		knifeCanvas.setFitHeight(30);
		knifeCanvas.setRotate(0);
		
		pane.getChildren().add(knifeCanvas);
		
		Scene scene = new Scene(pane, 670, 1139);
		primaryStage.setTitle("Lava Sea Snake");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
		// swing.setAutoReverse(true);
		fullAnimation.play();
	}
	
	class SwingHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			knifeCanvas.setRotate(knifeCanvas.getRotate() + 30);
		}
	}
	class SwingBackHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			knifeCanvas.setRotate(knifeCanvas.getRotate() - 30);
		}
	}
	public static void main (String[] args) {
		launch(args);
	}
}
