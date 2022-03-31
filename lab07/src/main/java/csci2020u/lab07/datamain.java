package csci2020u.lab07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class datamain extends Application {
    public void start(Stage primaryStage) throws Exception {
        try{
            Parent first = FXMLLoader.load(getClass().getResource("visuals.fxml"));
            Scene mainMenu = new Scene(first);
            primaryStage.setScene(mainMenu);
            primaryStage.show();
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

