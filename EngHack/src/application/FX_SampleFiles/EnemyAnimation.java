package application.FX_SampleFiles;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EnemyAnimation extends Application{
	public Timeline t;
	public Rectangle enemy;
	public Rectangle player;
	
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		t = new Timeline(new KeyFrame(Duration.millis(10), new EnemyHandler()));
		
		enemy = new Rectangle(20, 20, 50, 50);
		enemy.setFill(Color.BLUE);
		player = new Rectangle(400, 20, 50, 50);
		player.setFill(Color.RED);
		
		pane.getChildren().addAll(enemy, player);
		
		Scene scene = new Scene(pane, 670, 1139);
		primaryStage.setTitle("Lava Sea Snake");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
	}
	
	class EnemyHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			enemy.setX(enemy.getX() + 2);
			if (player.getBoundsInLocal().intersects(enemy.getBoundsInLocal())){
				System.out.println("Good !");
				t.pause();
			}
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
