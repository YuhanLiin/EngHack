package game;


import java.util.ArrayList;

import application.CharacterSm;
import application.EnemySm;
import hitbox.Attack;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {
	public final int height = 600;
	public final int width = 800;
	public ArrayList<EnemySm> enemies = new ArrayList<EnemySm>();
	public ArrayList<Attack> playerAttacks = new ArrayList<Attack>();
	public ArrayList<Attack> enemyAttacks = new ArrayList<Attack>();
	public CharacterSm player;
	public int frameCount = 0;
	Pane pane;
	Timeline timeline;
	
	public void start(Stage primaryStage){
		player = new CharacterSm(this, 300, 400, 100, 100);

		
		pane = new Pane();
		pane.getChildren().add(player.view);
		pane.setOnKeyPressed(new KeyEventHandler());
		
		Scene scene = new Scene(pane, 670, 1139);
		primaryStage.setTitle("");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		pane.requestFocus();
		
		timeline = new Timeline(new KeyFrame(Duration.millis(1000/60), new FrameHandler()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		
	}
	
	public static void main(String []args){
		launch(args);
	}
	
	class KeyEventHandler implements EventHandler<KeyEvent>{
		public void handle(KeyEvent e){
			switch (e.getCode()){	// with pressed actions, getCode() returns enumerated type. getr1() returns the String version
				case DOWN: player.moveDown();  break;
				case UP: player.moveUp(); break;
				case LEFT: player.moveLeft(); break;
				case RIGHT: player.moveRight(); break;
				// The default statement throws exceptions if SHIFT or COMMAND are pressed. Leaving it out, no exceptions are thrown, but the character displayed cannot be changed
				/*default:
					if (Character.isLetterOrDigit(e.getr1().charAt(0)));
						r1.setr1(e.getr1());	// The character that got pressed*/
			}
		}
	}
	
	class FrameHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			frameCount++;
			player.move();
//			if (frameCount % (60*5) == 0){
//				EnemySm enemy = new EnemySm();
//				pane.getChildren().add(enemy.view);
//				enemies.add(enemy);
//			}
//			for (EnemySm enemy: enemies){
//				if (/*enemy is ded*/){
//					enemies.remove(enemy);
//					pane.getChildren().remove(enemy.view);
//				}
//			}
		}
	}
}