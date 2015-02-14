package net.austinj.goldenticket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class MainClass extends Application {
	@Override public void start(Stage stage) {
		
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("http://google.com/");
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root,270,480);
		
		root.getChildren().add(browser);
		
		stage.setTitle("golden-ticket");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args){
		
		File file = new File(System.getProperty("user.home")+"/Desktop/newfile.txt");
		System.out.println(file.getAbsoluteFile().toPath());
		if (!file.exists()) {
		     InputStream link = (MainClass.class.getResourceAsStream("/html/index.html"));
		     try {
		    	 Files.copy(link, file.getAbsoluteFile().toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		launch(args);
	}
}