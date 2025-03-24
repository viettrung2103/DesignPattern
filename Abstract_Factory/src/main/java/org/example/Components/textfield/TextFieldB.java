package org.example.Components.textfield;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TextFieldB extends AbstractTextField{
    public TextFieldB(HBox hBox, String text) {
        super(hBox, text);
    }
    @Override
    public void display() {
        TextField textField = new TextField(super.getText());
        Font font = Font.font("Dialog", FontWeight.BOLD, 12);

        textField.setFont(font);
        textField.setPrefSize(400, 200);
        textField.setStyle("-fx-background-color:grey;-fx-text-fill:white;");
        super.gethBox().getChildren().add(textField);;
        super.setTextField(textField);
    }
}
