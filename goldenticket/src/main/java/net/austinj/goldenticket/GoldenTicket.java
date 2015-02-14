package net.austinj.goldenticket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;


public class GoldenTicket extends Application {
	
	public static String t = "\u2514\u2500\u2500";
	public static String tl = "\u2514\u2500\u2500\u2500\u2500";
	
	@Override public void start(Stage stage) {
		
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("file://"+new File(Resources.getTempDir()+"html/index.html").getAbsolutePath());
		browser.setFontSmoothingType(FontSmoothingType.LCD);
		
		JSObject jsobj = (JSObject) webEngine.executeScript("window");
		jsobj.setMember("java", new Bridge());
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root,300,500);
		
		root.getChildren().add(browser);
		
		stage.setTitle("golden-ticket");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args){
		Resources.wrangleResources();
		launch(args);
		safelyExit();
	}
	
	public static void safelyExit(){
		
		try {
			FileUtils.deleteDirectory(new File(Resources.getTempDir()));
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		
		System.exit(0);
		
	}
	
}