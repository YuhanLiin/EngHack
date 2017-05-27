package application;


import java.util.ArrayList;

import application.EnemySm;
import hitbox.Attack;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
	public final int height = 600;
	public final int width = 800;
	public ArrayList<EnemySm> enemies = ArrayList<CharacterSm>();
	public ArrayList<Attack> playerAttacks = ArrayList<Attack>();
	public ArrayList<Attack> enemyAttacks = ArrayList<Attack>();
	public PlayerSm player;
	public int frameCount = 0;
	Pane pane;
	
	public void start(Stage primaryStage){
		player = new PlayerSm(this, 300, 400, 100, 100);

		
		pane = new Pane();
		pane.getChildren().addAll(/* player.imageviews list */);
		pane.setOnKeyPressed(new KeyEventHandler());
		
		Scene scene = new Scene(pane, 670, 1139);
		primaryStage.setTitle("");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
		
	}
	
	public static void main(String []args){
		launch(args);
	}
	
	class KeyEventHandler implements EventHandler<KeyEvent>{
		public void handle(KeyEvent e){
			switch (e.getCode()){	// with pressed actions, getCode() returns enumerated type. getr1() returns the String version
				case DOWN: r1.setY(r1.getY() + 10); break;
				case UP: r1.setY(r1.getY() - 10); break;
				case LEFT: r1.setX(r1.getX() - 10); break;
				case RIGHT: r1.setX(r1.getX() + 10); break;
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
			if (frameCount % (60*5) == 0){
				EnemySm enemy = new EnemySm();
				//pane.add(imageview)
				enemies.add(enemy);
			}
			for (EnemySm enemy: enemies){
				if (/*enemy is ded*/){
					enemies.remove(enemy);
					//pane.getChildren().remove(imageview)
				}
			}
		}
	}
}