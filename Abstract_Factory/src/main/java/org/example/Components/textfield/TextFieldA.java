package org.example.Components.textfield;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TextFieldA extends AbstractTextField{

    public TextFieldA(HBox hBox, String text) {
        super(hBox, text);
    }

    @Override
    public void display() {
        TextField textField = new TextField(super.getText() );
        Font font = Font.font("Courier New", FontWeight.BOLD, 14);

        textField.setFont(font);
        textField.setPrefSize(300, 100);
        textField.setStyle("-fx-background-color:#ff2143;-fx-text-fill:white;");
        super.gethBox().getChildren().add(textField);
        super.setTextField(textField);
    }
}
