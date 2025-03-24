package org.example.Components;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Components.factory.AFactory;
import org.example.Components.factory.BFactory;

public class GUI extends Application {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        VBox container = new VBox();
        HBox hbox1 = new HBox();
        String text1 = "This is text 1";
        HBox hbox2 = new HBox();
        String text2 = "This is text 2";
        AFactory aFactory = new AFactory(hbox1, text1);
        aFactory.createButton().display();
        aFactory.createTextField().display();
        aFactory.createCheckBox().display();

        BFactory bFactory = new BFactory(hbox2, text2);
        bFactory.createButton().display();
        bFactory.createTextField().display();
        bFactory.createCheckBox().display();

        HBox hBox3 = new HBox();
        TextField textField = new TextField();
        Button changeTextButton = new Button("Change Text");
        changeTextButton.setOnAction(e -> {
            String newText = textField.getText();
//            aFactory.setText(newText);
//            bFactory.setText(newText);
        });
        Insets margin = new Insets(10,10,10,10);
        HBox.setMargin(hBox3, margin);
        hBox3.getChildren().addAll(textField, changeTextButton);

        container.getChildren().addAll(hbox1,hbox2,hBox3);
        root.getChildren().add(container);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Abstract Factory Pattern");
        stage.show();
    }

    // for the last assignment, how to create a setText method that work for all class.
    // I plan to create a super parent class of all these classes,
    // then I create a setText method in the super parent class
    // I also will implement a setComponent method in order to store the JavaFx component
    // in the supper parent class, so that when I setText, I will set the text of this JavaFx component
    // in THe UIFactory, I will create a list of the super parent class, where I store all the JavaFx component
    // that has been created, then I will called the setText method of the super parent class in the loop.
    // Therefore, I google to find the parent class of  Checkbox, TextField, and Button where there is a setText method
    // However, I could not find it
    // The TextField's super class that has a setText method is TextInputControl
    // whereas the Buttons's and CheckBox's super class that has a setText method is Labeled
    // Therefore, it is impossible to create a setText method that works for all classes


}