package com.tesla.components;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {
    public static void displayAlert(String alertTitle, String alertMessage) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(alertTitle);
        window.setMinHeight(200);
        window.setMinWidth(300);

        Label label = new Label();
        label.setText(alertMessage);

        Button button = new Button();
        button.setText("Exit");
        button.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, button);

        Scene scene = new Scene(layout, 250, 250);
        window.setScene(scene);
        window.showAndWait();
    }
}