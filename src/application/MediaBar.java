package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

public class MediaBar extends HBox {
	Slider time = new Slider();
	Slider vol = new Slider();
	Button playButton = new Button("||");
	Label volume = new Label("Volume: ");
	MediaPlayer player;

	public MediaBar(MediaPlayer play){
		player = play;

		setAlignment(Pos.CENTER);
		setPadding(new Insets(5, 10, 5, 10));

		vol.setPrefWidth(70);
		vol.setMinWidth(30);
		vol.setValue(100);

		HBox.setHgrow(time, Priority.ALWAYS );

		playButton.setPrefWidth(30);

		getChildren().add(playButton);
		getChildren().add(time);
		getChildren().add(volume);
		getChildren().add(vol);


	}


}
