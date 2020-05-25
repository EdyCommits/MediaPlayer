package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

import static javafx.scene.media.MediaPlayer.*;

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

		playButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Status status = player.getStatus();
				if(status.equals(Status.PLAYING)){
					if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
						player.seek(player.getStartTime());
						player.play();
					}
					else {
						player.pause();
						playButton.setText(">");
					}
				}
				if(status.equals(Status.PAUSED) || status.equals(Status.HALTED) || status.equals(Status.STOPPED)){
					player.play();
					playButton.setText("||");
				}
			}
		});

	}


}
