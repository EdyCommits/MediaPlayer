package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

  @Override
  public void  start(Stage primaryStage) {
      Player player = new Player("file:/Users/edytabednarz/Developer/Video.mp4");
      Scene scene = new Scene(player, 720, 480, Color.BLACK);
      primaryStage.setScene(scene);
      primaryStage.show();
  }

    public static void main(String[] args) {
        launch(args);
    }
}
