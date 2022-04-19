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
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			 String path = "src/application/tetrismenu.mp3";  
	          
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
