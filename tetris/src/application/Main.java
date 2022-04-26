package application;
	
import java.io.File;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.media.*;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = new AnchorPane();
			 root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		    Scene scene = new Scene(root,400,600);
		    root.setStyle("-fx-background-image:url('Main.png'); -fx-background-repeat: no-repeat; -fx-background-size: 400 600; -fx-background-position: center center;");
			//String css =this.getClass().getResource("/application/application.css").toExternalForm();
			//primaryStage.getStylesheets().add(css);
			primaryStage.setScene(scene);
			
			 String path = "src/application/tetrisgame.mp3";  
	          
		        //Instantiating Media class  
		        Media media = new Media(new File(path).toURI().toString());  
		          
		        //Instantiating MediaPlayer class   
		        MediaPlayer mediaPlayer = new MediaPlayer(media);  
		        mediaPlayer.setOnEndOfMedia(new Runnable() {
		            @Override
		            public void run() {
		                mediaPlayer.seek(Duration.ZERO);
		                mediaPlayer.play();
		            }
		        }); 
		        
		        //by setting this property to true, the audio will be played   
		        mediaPlayer.setAutoPlay(true);  
		        primaryStage.setTitle("Tetris");  
		        primaryStage.show();  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
