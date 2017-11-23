package Home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class home extends Application{
    public void start(Stage stage)throws Exception{
        Parent root=(Parent) FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene=new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Result Analysis System");
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}