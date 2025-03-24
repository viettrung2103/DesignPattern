package org.example.Components.button;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ButtonA extends AbstractButton {

    public ButtonA(HBox hBox, String text) {
        super(hBox,text);
    }


    @Override
    public void display() {
        System.out.println("ButtonA displayed");
        Button button = new Button(super.getText());
        Font font = Font.font("Courier New", FontWeight.BOLD, 14);

        button.setFont(font);

        button.setPrefSize(300, 100);
        button.setFocusTraversable(Boolean.TRUE);
        button.setStyle("-fx-background-color:#ff2143;-fx-text-fill:white;");
        super.getHBox().getChildren().add(button);
        super.setButton(button);

    }
}
