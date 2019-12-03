package sample;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Vending Machine");
        primaryStage.setScene(new Scene(root, 700, 630));
        primaryStage.getIcons().add(new Image(this.getClass().getResource("ven2.png").toString()));
        primaryStage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Welcome");
        alert.setHeaderText("Welcome to Vending Machine Created by Group Minions!");
        alert.setContentText("Powered by Emon");
        ButtonType buttonTypeOne = new ButtonType("ContinueShopping");
        alert.getButtonTypes().setAll(buttonTypeOne);
        alert.setGraphic(new ImageView(this.getClass().getResource("wel.png").toString()));

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

// Add a custom icon.
        stage.getIcons().add(new Image(this.getClass().getResource("Cart.png").toString()));
        alert.showAndWait();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
