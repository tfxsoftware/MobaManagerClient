package hellofx;

import java.io.IOException;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginLayout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        primaryStage.setTitle("MobaManager");
        primaryStage.setScene(tela);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) throws UnknownHostException, IOException {
        launch(args);
    }
}