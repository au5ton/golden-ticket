import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 Welcome! This is JavaFx Tutorial 2.
 In the last tutorial, we covered a button that when clicked, changed it's text to "Hello World!".
 This tutorial, we will be learning more about buttons.
 */
public class InterfaceThing extends Application {

    @Override
    public void start(Stage stage) {

        Button btn = new Button();
        btn.setText("Example");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //hello
            }
        });
        Scene scene = new Scene(null,300, 300);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
