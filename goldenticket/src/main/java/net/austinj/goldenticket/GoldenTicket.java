package net.austinj.goldenticket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class GoldenTicket extends Application {
	
	static String t = "\u2514\u2500\u2500";
	static String tl = "\u2514\u2500\u2500\u2500\u2500";
	static String tempDir = System.getProperty("user.home")+"/Desktop/net.austinj.goldenticket/";
	
	static String[] assets = {
		"html/index.html",
		"html/css/font-awesome.min.css",
		"html/fonts/fontawesome-webfont.eot",
		"html/fonts/fontawesome-webfont.svg",
		"html/fonts/fontawesome-webfont.ttf",
		"html/fonts/fontawesome-webfont.woff",
		"html/fonts/fontawesome-webfont.woff2",
		"html/fonts/FontAwesome.otf",
		"html/js/jquery-2.1.3.min.js"
	};
	
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
		
		System.out.println("Preparing extraction...");
		File dir = new File(tempDir);
		if(!dir.exists()){
			System.out.print(t+"Creating temporary file directory...");
			dir.mkdir();
			System.out.println("Done.");
			System.out.println(t+"Temporary file directory at: "+tempDir);
		}
		else {
			System.out.println(t+"Temporary directory already exists for some reason? Oh well.");
		}
		System.out.println("Done.\n");
		
		
		System.out.println("Starting extraction...");
		for(int i = 0; i < assets.length; i++){
			File file = new File(tempDir+assets[i]);
			
			System.out.println(t+"Checking file ("+assets[i]+") at:");
			System.out.println(t+file.getAbsolutePath());
			
			if (!file.exists()) {
				System.out.println(t+"This planned file desination does not have something else already there.");
				System.out.println(t+"Looking for file in JAR...");
				InputStream link = null;
			    try {
			    	link = (GoldenTicket.class.getResourceAsStream(assets[i]));
			    	System.out.println(t+"I guess we found it!");
			    }
			    catch(Exception e){
			    	System.out.println(t+"Ugh. No luck.");
			    	e.printStackTrace(System.out);
			    }
			    try {
			    	System.out.println(t+"Attempting to read from the JAR file...");
			    	Files.copy(link, file.getAbsoluteFile().toPath());
			    	System.out.println(t+"It's good!");
				} 
			    catch (Exception e) {
					System.out.println(t+"That failed.");
					e.printStackTrace(System.out);
					
					try {
				    	System.out.println(tl+"Attempting to read like a normal file instead...");
				    	System.out.println(tl+new File(assets[i]).getAbsolutePath());
				    	FileUtils.copyFile(new File(assets[i]), file);
				    	System.out.println(tl+"It's good!");
					} 
				    catch (IOException err) {
						System.out.println(tl+"That failed.");
						e.printStackTrace(System.out);
					}
					
				}
			}
			else {
				System.out.println(t+"This file already exists???\n");
			}
		}
		
		System.out.println("Done.");
		System.out.println("Extraction complete.");
		
		launch(args);
		
		safelyExit();
	}
	
	public static void safelyExit(){
		
		try {
			FileUtils.deleteDirectory(new File(tempDir));
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		
		System.exit(0);
		
	}
	
}