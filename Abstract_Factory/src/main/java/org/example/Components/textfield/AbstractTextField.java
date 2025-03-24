package org.example.Components.textfield;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class AbstractTextField {
    private HBox hBox;
    private String text;
    private TextField textField;
    public AbstractTextField(HBox hBox, String text) {
        this.hBox = hBox;
        this.text = text;
    }

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.textField.setText(text);
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public abstract void display();
}
