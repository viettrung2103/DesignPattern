package org.example.Components.button;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ButtonB extends AbstractButton {

    public ButtonB(HBox hBox,String text){
        super(hBox,text);
    }

    @Override
            public void display() {
           System.out.println("ButtonA displayed");
    Button button = new Button(super.getText());
    Font font = Font.font("Dialog", FontWeight.BOLD, 12);

        button.setFont(font);
        button.setPrefSize(400, 200);
        button.setFocusTraversable(Boolean.TRUE);
        button.setStyle("-fx-background-color:grey;-fx-text-fill:white;");
        super.getHBox().getChildren().add(button);
        super.setButton(button);
}}
