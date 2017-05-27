package application.FX_SampleFiles;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.layout.Pane;
 import javafx.stage.Stage;
 import javafx.scene.input.KeyEvent;
 import javafx.event.EventHandler;


public class PlayerMovement extends Application {
	public Rectangle r1;
	
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		r1 = new Rectangle(20, 20, 50, 50);
		r1.setFill(Color.BLUE);
		
		pane.setOnKeyPressed(new KeyEventHandler());
		
		pane.getChildren().add(r1);
		
		// Prepare the Scene and Stage
		Scene scene = new Scene(pane, 670, 1139);
		primaryStage.setTitle("Lava Sea Snake");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
		
		pane.requestFocus();
	}
	// Sample Code
	
	/*
	 *  case DOWN: r1.setY(r1.getY() + 10); break;
		case UP: r1.setY(r1.getY() - 10); break;
		case LEFT: r1.setX(r1.getX() - 10); break;
		case RIGHT: r1.setX(r1.getX() + 10); break;
	 * 
	 * 
	 */
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
		
	public static void main (String[] args) {
		launch(args);
	}
}
