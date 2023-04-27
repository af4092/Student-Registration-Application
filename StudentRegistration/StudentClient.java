package com.special.effect.javafxprojects.StudentRegistration;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient extends Application {
    private TextField txtName = new TextField();
    private TextField txtStreet = new TextField();
    private TextField txtCity = new TextField();
    private TextField txtState = new TextField();
    private TextField txtZip = new TextField();
    private Button btnRegister = new Button("Register to the server");
    String host = "localhost";

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();

        pane.add(new Label("Name"), 0, 0);
        pane.add(txtName, 1, 0);

        pane.add(new Label("Street"), 0, 1);
        pane.add(txtStreet, 1, 1);

        HBox hBox = new HBox(2);
        pane.add(hBox, 1, 2);
        pane.add(new Label("City"),0, 2);
        hBox.getChildren().addAll(txtCity, new Label("State"), txtState, new Label("Zip"), txtZip);

        pane.add(btnRegister, 1, 3);
        GridPane.setHalignment(btnRegister, HPos.RIGHT);

        pane.setAlignment(Pos.CENTER);
        txtName.setPrefColumnCount(15);
        txtStreet.setPrefColumnCount(15);
        txtCity.setPrefColumnCount(10);
        txtState.setPrefColumnCount(2);
        txtZip.setPrefColumnCount(3);

        btnRegister.setOnAction(new ButtonListener());

        Scene scene = new Scene(pane, 450, 200);
        stage.setTitle("Student Client");
        stage.setScene(scene);
        stage.show();
    }

    private class ButtonListener implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            try{
                Socket socket = new Socket(host, 8000);

                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

                String name = txtName.getText().trim();
                String street = txtStreet.getText().trim();
                String city = txtCity.getText().trim();
                String state = txtState.getText().trim();
                String zip = txtZip.getText().trim();

                StudentAddress studentAddress = new StudentAddress(name, street, city, state, zip);
                toServer.writeObject(studentAddress);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
